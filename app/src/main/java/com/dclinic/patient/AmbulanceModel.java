package com.dclinic.patient;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AmbulanceModel{

	@SerializedName("data")
	private List<DataItem> data;

	public List<DataItem> getData(){
		return data;
	}
}