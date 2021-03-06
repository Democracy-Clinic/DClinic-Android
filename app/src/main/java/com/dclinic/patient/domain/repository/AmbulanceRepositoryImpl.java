package com.dclinic.patient.domain.repository;

import android.content.Context;

import com.dclinic.patient.AmbulanceDataItem;
import com.dclinic.patient.AmbulanceModel;
import com.dclinic.patient.utils.Utils;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;


/**
 * Created by HeinHtetZaw on 3/5/21.
 */
public class AmbulanceRepositoryImpl implements AmbulanceRepository {

    private Context context;

    public AmbulanceRepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<AmbulanceDataItem>> getAmbulanceList() {
       /*return Observable.fromAction(() -> {
           throw new Exception("Exception occurred");
       });*/

        Gson gson = new Gson();
        String str = Utils.getJson(context, "ambulance_data.json");
        AmbulanceModel model = gson.fromJson(str, AmbulanceModel.class);
        return Observable.fromArray(model.getData());
    }
}
