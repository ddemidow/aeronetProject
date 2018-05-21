package com.example.callout.controllers;

import com.example.Utils.Utils;
import com.example.callout.services.AeronetDataLoader;
import com.example.callout.utils.AeronetRequestBuilder;
import com.example.entities.DiscoveryItem;
import com.example.entities.Location;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class SalesforceController {
	private String sessionId;

	public void uploadLocationsToSalesforce(ArrayList<Location> locations, String sessionId) {
		if (sessionId == null) {
			System.out.println("Please get session Id:");
			Scanner scanner = new Scanner(System.in);

			this.sessionId = scanner.next();
		} else {
			this.sessionId = sessionId;
		}


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + this.sessionId);

		RestTemplate template = new RestTemplate();

		String putBodyJson = Utils.serializeObjectToJSON(new Utils.LocationWrapper(locations));

		System.out.println(putBodyJson);

		HttpEntity<String> entity = new HttpEntity<String>(putBodyJson ,headers);

		ResponseEntity<String> response = template.exchange(Utils.ADD_LOCATION_ENDPOINT, HttpMethod.PUT, entity, String.class);

		System.out.println(response.getStatusCode());
	}

	public void uploadCalculatedDiscoveryItemsByLocation (HashMap<Utils.CalculatedDiscoveryItemType, DiscoveryItem> calculatedItemsByType, String locationName,
														  String sessionId) {
        if (sessionId == null) {
            System.out.println("Please get session Id:");
            Scanner scanner = new Scanner(System.in);

            this.sessionId = scanner.next();
        } else {
            this.sessionId = sessionId;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.sessionId);

        RestTemplate template = new RestTemplate();

        ArrayList<Utils.DiscoveryItemWrapper> discoveryItemWrappers = new ArrayList<>();

        for (Utils.CalculatedDiscoveryItemType currentCalculatedDiscoveryItemType : calculatedItemsByType.keySet()) {
            discoveryItemWrappers.add(new Utils.DiscoveryItemWrapper(calculatedItemsByType.get(currentCalculatedDiscoveryItemType),
                    currentCalculatedDiscoveryItemType, locationName));
        }

        String putBodyJson = Utils.serializeObjectToJSON(new Utils.DiscoveryItemsWrapperRequest(discoveryItemWrappers));

        System.out.println(putBodyJson);

        HttpEntity<String> entity = new HttpEntity<String>(putBodyJson ,headers);

        ResponseEntity<String> response = template.exchange(Utils.ADD_DISCOVERY_ITEM_ENDPOINT, HttpMethod.PUT, entity, String.class);

        System.out.println(response.getStatusCode());
	}

	public static void main(String[] args) {
		SalesforceController sfController = new SalesforceController();




		AeronetDataLoader dataLoadingController = new AeronetDataLoader();

		AeronetRequestBuilder builder = new AeronetRequestBuilder();
		String request = builder.setStartDate(LocalDateTime.now().minusYears(18)).setEndDate(LocalDateTime.now().minusYears(17).plusDays(7)).setAVG(20).setSite("Minsk").setIfNoHtml(true).setAod(1).buildDiscoveryItemRequest();
		System.out.println(request);

		//https://aeronet.gsfc.nasa.gov/cgi-bin/print_web_data_v3?&if_no_html=1&month2=APRIL&AVG=12&site=Cart_Site&hour2=16&month=APRIL&hour=16&year=2000&day2=20&day=20&year2=2001
		ArrayList<DiscoveryItem> items = new AeronetDataLoader().getDiscoveryItems(request);




		sfController.uploadCalculatedDiscoveryItemsByLocation(Utils.getAverageDiscoveryItem(items), "Minsk", null);
	}

	private class Response {
		private Integer statusCode;
		private Boolean isError;
		private String message;

		public Integer getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(Integer statusCode) {
			this.statusCode = statusCode;
		}

		public Boolean getError() {
			return isError;
		}

		public void setError(Boolean error) {
			isError = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "Response{" +
					"statusCode=" + statusCode +
					", isError=" + isError +
					", message='" + message + '\'' +
					'}';
		}
	}
}
