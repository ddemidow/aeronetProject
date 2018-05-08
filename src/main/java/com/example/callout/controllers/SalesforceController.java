package com.example.callout.controllers;

import com.example.Utils.Utils;
import com.example.entities.Location;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

        String putBodyJson = Utils.serializeObjectToJSON(new Utils.Wrapper(locations));

        System.out.println(putBodyJson);

        HttpEntity<String> entity = new HttpEntity<String>(putBodyJson ,headers);

        ResponseEntity<String> response = template.exchange(Utils.ADD_LOCATION_ENDPOINT, HttpMethod.PUT, entity, String.class);

        System.out.println(response.getStatusCode());
    }

    public static void main(String[] args) {
        SalesforceController sfController = new SalesforceController();

        Location loc = new Location();
        loc.setName("testSF_Finish_List");
        loc.setLongitude(12.3);
        loc.setLatitude(45.5);
        loc.setElevation(34.5);

        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(loc);
        locations.add(loc);

        sfController.uploadLocationsToSalesforce(locations, null);
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
