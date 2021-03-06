package com.dclinic.patient.domain.repository;

import com.dclinic.patient.AmbulanceDataItem;
import com.dclinic.patient.AmbulanceModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by HeinHtetZaw on 3/5/21.
 */
public interface AmbulanceRepository {
    Observable<List<AmbulanceDataItem>> getAmbulanceList();
}
