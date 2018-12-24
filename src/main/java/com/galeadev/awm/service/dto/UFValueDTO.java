package com.galeadev.awm.service.dto;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class UFValueDTO {
	
	@SerializedName("Valor")
	private String ufStrValue = null;
	
	@SerializedName("Fecha")
	private Date ufDate = null;
	
	public UFValueDTO() {
		super();
	}

	public UFValueDTO(String ufStrValue, Date ufDate) {
		super();
		this.ufStrValue = ufStrValue;
		this.ufDate = ufDate;
	}

	public String getUfStrValue() {
		return ufStrValue;
	}

	public void setUfStrValue(String ufStrValue) {
		this.ufStrValue = ufStrValue;
	}

	public Date getUfDate() {
		return ufDate;
	}

	public void setUfDate(Date ufDate) {
		this.ufDate = ufDate;
	}

}