package com.galeadev.awm.web.restclients;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.galeadev.awm.service.dto.UFValueDTO;

public class SBIFUFClient {

	final static String sbifServiceURL = "https://api.sbif.cl/api-sbifv3/recursos_api/uf?apikey=${apikey}&formato=${serviceFormat}";
	final static String sbifApiKey = "9e4e7d7959c77495c953818fa7cc12ed29bf57a4";
	final static String serviceFormat = "json";
	
	final static String dateFormat = "yyyy-MM-dd";
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();

		WebTarget ufServiceTarget = client
				.target(sbifServiceURL.replace("${apikey}", sbifApiKey).replace("${serviceFormat}", serviceFormat));

		JSONObject obj = new JSONObject(ufServiceTarget.request().get(String.class));

		String UFs = obj.getJSONArray("UFs").get(0).toString();

		Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();

		UFValueDTO ufVal = gson.fromJson(UFs, UFValueDTO.class);
		
	}

}