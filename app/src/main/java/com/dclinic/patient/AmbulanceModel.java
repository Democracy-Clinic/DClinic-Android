package com.dclinic.patient;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AmbulanceModel{

	@SerializedName("data")
	private List<AmbulanceDataItem> data;

	public List<AmbulanceDataItem> getData(){
		return data;
	}
}