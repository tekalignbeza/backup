/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybot.rest.search;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybot.application.search.RabbitmqService;
import com.mybot.domain.search.WebSearchRequest;
import com.mybot.domain.search.WebSearchResponse;

/**
 *
 * @author teke
 */
@Controller
@RequestMapping(value = "/event")
public class WebSearchController {

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResponseEntity<WebSearchResponse> getPage(@RequestBody WebSearchRequest webSearchRequest) {
		ObjectMapper mapper = new ObjectMapper();
		RabbitmqService processingClient = null;
		WebSearchResponse webSearchResponse = null;
		try {
			// TODO get user preference
			List<String> preference = new ArrayList<String>();
			if (webSearchRequest.getPreference() != null) {
				webSearchRequest.getPreference().addAll(preference);
			} else {
				webSearchRequest.setPreference(preference);
			}
			String jsonInString = mapper.writeValueAsString(webSearchRequest);
			processingClient = new RabbitmqService();
			String respose = processingClient.call(jsonInString);
			webSearchResponse = mapper.readValue(respose, WebSearchResponse.class);
		} catch (Exception ex) {
			Logger.getLogger(WebSearchController.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (processingClient != null) {
				try {
					processingClient.close();
				} catch (Exception ignore) {
				}
			}
		}
		return new ResponseEntity<WebSearchResponse>(webSearchResponse, HttpStatus.OK);
	}
}
