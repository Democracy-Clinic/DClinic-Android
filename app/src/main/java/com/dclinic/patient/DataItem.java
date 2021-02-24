package com.dclinic.patient;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("address")
	private String address;

	@SerializedName("hour")
	private String hour;

	@SerializedName("service")
	private String service;

	@SerializedName("fee")
	private String fee;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("township")
	private String township;

	public String getAddress(){
		return address;
	}

	public String getHour(){
		return hour;
	}

	public String getService(){
		return service;
	}

	public String getFee(){
		return fee;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getTownship(){
		return township;
	}
}