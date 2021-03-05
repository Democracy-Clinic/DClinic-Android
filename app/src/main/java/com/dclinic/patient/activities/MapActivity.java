package com.dclinic.patient.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.dclinic.patient.R;
import com.dclinic.patient.data.vos.map.ClinicsMapVO;
import com.dclinic.patient.databinding.ActivityMapBinding;
import com.dclinic.patient.viewmodels.MapViewModel;
import com.mapzen.android.lost.api.LocationListener;
import com.mapzen.android.lost.api.LocationRequest;
import com.mapzen.android.lost.api.LocationServices;
import com.mapzen.android.lost.api.LostApiClient;

import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MapActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks, LostApiClient.ConnectionCallbacks, ItemizedOverlay.OnFocusChangeListener {

    LostApiClient lostApiClient;
    private HashMap<String, ClinicsMapVO> mergedLocationListMap = new HashMap<String, ClinicsMapVO>(); // for referencing the UI controls
    private HashMap<String, org.osmdroid.views.overlay.OverlayItem> mapMarkerList = new HashMap<String, OverlayItem>(); // for referencing data from map to UI code and vice versa

    private OverlayItemMapper overlayItemMapper = new OverlayItemMapper();
    private ItemizedIconOverlay mapViewPoint;
    LocationRequest request = LocationRequest.create()
        .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        .setInterval(5000)
        .setSmallestDisplacement(10);

    private static final int RC_CAMERA_AND_LOCATION = 1001;
    private final String TAG = this.getClass().getSimpleName();
    ActivityMapBinding binding;
    String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
    private MapViewModel viewModel;

    @Override
    int inflate() {
        return R.layout.activity_map;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapBinding.inflate(getLayoutInflater());
        lostApiClient = new LostApiClient
            .Builder(this)
            .addConnectionCallbacks(this)
            .build();
        setContentView(binding.getRoot());
        viewModel = ViewModelProviders.of(this).get(MapViewModel.class);
        initMap();
    }


    @Override
    void init() {
//        addBackButton(binding.toolBar, R.drawable.ic_arrow_back, 0);
        viewModel.loadClinicList(0.0,0.0);
    }

    private void initMap() {
        binding.mapView.setBuiltInZoomControls(true);
        binding.mapView.setMultiTouchControls(true);
        OnlineTileSourceBase myTile = new XYTileSource(
            "cartodb",
            1,
            20,
            256,
            ".png",
            new String[]{"https://cartodb-basemaps-a.global.ssl.fastly.net/light_all/"},
            "© OpenStreetMap contributors"
        );
        binding.mapView.setTileSource(myTile);
        binding.mapView.getController().setZoom(12.5);

        GeoPoint initPoint = new GeoPoint(16.846249823565806, 96.19347393699604); //setting YGN
        binding.mapView.getController().setCenter(initPoint);
    }

    @AfterPermissionGranted(RC_CAMERA_AND_LOCATION)
    private void methodRequiresTwoPermission() {

        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
            getUserCurrentLocation();
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.location_rationale),
                RC_CAMERA_AND_LOCATION, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Log.i(TAG, "onPermissionsGranted got called :" + requestCode + ":" + perms.size());
        getUserCurrentLocation();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen, like showing a Toast.
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.d(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());

        // (Optional) Check whether the user denied any permissions and checked "NEVER ASK AGAIN."
        // This will display a dialog directing them to enable the permission in app settings.
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onRationaleAccepted(int requestCode) {

    }

    @Override
    public void onRationaleDenied(int requestCode) {

    }

    @SuppressLint("MissingPermission")
    public void getUserCurrentLocation() {
        lostApiClient.connect();
        LocationServices.FusedLocationApi.requestLocationUpdates(lostApiClient, request, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }
        });
    }

    @Override
    public void onConnected() {


    }

    @Override
    public void onConnectionSuspended() {

    }

    private void addMapPoints() {
        binding.mapView.getOverlays().clear(); // clearing the previous overlays
//        resetLocationListMap()

        mapMarkerList.clear();
        //converting location list to List<OverLayItem> and put that overLay list to the hashMap
        ArrayList<OverlayItem> overlayItemsList = new ArrayList<>();

        for (ClinicsMapVO data : mergedLocationListMap.values()) {
            overlayItemsList.add(overlayItemMapper.map(data));
        }

        //the overlay
        mapViewPoint =
            new ItemizedIconOverlay(
                new ArrayList(mapMarkerList.values()),
                Objects.requireNonNull(ContextCompat.getDrawable(this, R.drawable.ic_location_small)),
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(int index, OverlayItem item) {
//                        show clinic details or something
                        return false;
                    }

                    @Override
                    public boolean onItemLongPress(int index, OverlayItem item) {
                        return false;
                    }
                }
                , this
            );
        mapViewPoint.setDrawFocusedItem(true);
        mapViewPoint.setOnFocusChangeListener(this);

        binding.mapView.getOverlays().add(mapViewPoint);
        binding.mapView.getController().setZoom(12.5);
    }

    @Override
    public void onFocusChanged(ItemizedOverlay<?> overlay, OverlayItem newFocus) {

    }
}