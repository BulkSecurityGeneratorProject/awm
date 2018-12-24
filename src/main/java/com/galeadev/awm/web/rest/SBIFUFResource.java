package com.galeadev.awm.web.rest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.galeadev.awm.service.dto.UFValueDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * REST controller for the rescue of the UF current value.
 */
@RestController
@RequestMapping("/api")
@ApplicationScope
public class SBIFUFResource {

	private final Logger log = LoggerFactory.getLogger(SBIFUFResource.class);

	final String sbifServiceURL = "https://api.sbif.cl/api-sbifv3/recursos_api/uf?apikey=${apikey}&formato=${serviceFormat}";
	final String sbifApiKey = "9e4e7d7959c77495c953818fa7cc12ed29bf57a4";
	final String serviceFormat = "json";

	final String dateFormat = "yyyy-MM-dd";

	final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
	final SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

	UFValueDTO ufCurrentValueBean = null;
	
	@GetMapping("/ufCurrentValue")
	public UFValueDTO getUFCurrentValue() {
		
		String currentDateString = dateTimeFormatter.format(LocalDate.now());
		
		if (ufCurrentValueBean == null || ufCurrentValueBean.getUfDate() == null || 
				!dateFormatter.format(ufCurrentValueBean.getUfDate()).equals(currentDateString)) {
			
			Client client = ClientBuilder.newClient();

			WebTarget ufServiceTarget = client
					.target(sbifServiceURL.replace("${apikey}", sbifApiKey).replace("${serviceFormat}", serviceFormat));

			JSONObject obj = new JSONObject(ufServiceTarget.request().get(String.class));

			String ufValueJson = obj.getJSONArray("UFs").get(0).toString();

			Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();

			ufCurrentValueBean = gson.fromJson(ufValueJson, UFValueDTO.class);
			
			log.info("New UF value rescued: {}", ufValueJson);
		
		} 

		return ufCurrentValueBean;
		
	}

}