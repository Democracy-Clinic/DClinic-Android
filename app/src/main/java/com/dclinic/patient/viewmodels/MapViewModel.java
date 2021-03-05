package com.dclinic.patient.viewmodels;

import androidx.lifecycle.MutableLiveData;

import com.dclinic.patient.data.vos.map.ClinicsMapVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeinHtetZaw on 2/17/21.
 */
public class MapViewModel extends BaseViewModel {

    private MutableLiveData<List<ClinicsMapVO>> clinicListData = new MutableLiveData<List<ClinicsMapVO>>();

    public void loadClinicList(double latitude, double longitude) {

    }

    private List<ClinicsMapVO> getDummyClinicList(){
        ArrayList<ClinicsMapVO> dummyList = new ArrayList();
        ClinicsMapVO data1 = new ClinicsMapVO("1","Shwe Gon Daing Hospital",16.8145813,96.1449323);
        ClinicsMapVO data2 = new ClinicsMapVO("2","Shwe Gon Daing Hospital",16.8108763,96.1656829);
        ClinicsMapVO data3 = new ClinicsMapVO("3","North OakKalar Hospital",16.8447847,96.1867334);
        ClinicsMapVO data4 = new ClinicsMapVO("4","Test Hospital",16.8142813,96.1441323);
        ClinicsMapVO data5 = new ClinicsMapVO("5","Test Hospital",16.8112813,96.1339323);
        dummyList.add(data1);
        dummyList.add(data2);
        dummyList.add(data3);
        dummyList.add(data4);
        dummyList.add(data5);
        return dummyList;
    }
}
