package com.example.callout.controllers;

import com.example.Utils.Utils;
import com.example.entities.Location;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

public class SalesforceController {
    public void uploadLocationsToSalesforce(ArrayList<Location> locations, String sessionId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + sessionId);

        RestTemplate template = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        template.exchange(Utils.ADD_LOCATION_ENDPOINT, HttpMethod.PUT, entity, String.class);

        String result = template.getForObject(Utils.ADD_LOCATION_ENDPOINT, String.class);
    }

    public static void main(String[] args) {
        final String uri = "https://login.salesforce.com";




        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        RestTemplate template = new RestTemplate();
        //templates
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
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
    }
}
