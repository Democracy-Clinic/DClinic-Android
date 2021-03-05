package com.dclinic.patient.activities;

import com.dclinic.patient.data.vos.map.ClinicsMapVO;
import com.dclinic.patient.mapper.BiMapper;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.OverlayItem;

/**
 * Created by HeinHtetZaw on 2/24/21.
 */
public class OverlayItemMapper extends BiMapper<ClinicsMapVO, OverlayItem> {
    @Override
    public OverlayItem map(ClinicsMapVO item) {
        return new OverlayItem(item.getClinicID(),item.getClinicName(),item.getAddress(),new GeoPoint(item.getLatitude(),item.getLongitude()));
    }

    @Override
    public ClinicsMapVO reverseMap(OverlayItem item) {
        return new ClinicsMapVO(item.getUid(),item.getTitle(),item.getPoint().getLatitude(),item.getPoint().getLongitude());
    }
}
}
