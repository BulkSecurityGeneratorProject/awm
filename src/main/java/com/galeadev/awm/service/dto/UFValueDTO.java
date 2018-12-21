package com.galeadev.awm.service.dto;

import java.util.Date;

public class UFValueDTO {
	
	private String Valor = null;
	private Date Fecha = null;
	
	public double getValor() {
		
		if (this.Valor!= null)
		this.Valor = Valor.replace(".", "").replace(",", ".");
		return Double.parseDouble(Valor);
	}
	
	public void setValor(String valor) {
		Valor = valor;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
}