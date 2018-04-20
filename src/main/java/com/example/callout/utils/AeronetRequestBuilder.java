package com.example.callout.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class AeronetRequestBuilder {
    private final String ITEMS_REQUEST_START_VALUE = "https://aeronet.gsfc.nasa.gov/cgi-bin/print_web_data_v3?";
    private final String LOCATIONS_REQUEST_START_VALUE = "https://aeronet.gsfc.nasa.gov/aeronet_locations_v3.txt";


    private String request;
    private HashMap<String, String> propertyToValue;

    public AeronetRequestBuilder() {
        propertyToValue = new HashMap<String, String>();

        propertyToValue.put("year", null);
        propertyToValue.put("month", null);
        propertyToValue.put("day", null);
        propertyToValue.put("year2", null);
        propertyToValue.put("month2", null);
        propertyToValue.put("day2", null);
        propertyToValue.put("hour", null);
        propertyToValue.put("hour2", null);
        propertyToValue.put("AVG", null);
        propertyToValue.put("site", null);
        propertyToValue.put("if_no_html", null);
        propertyToValue.put("AOD10", null);
    }

    public String buildDiscoveryItemRequest() {
        validateRequest();

        request = ITEMS_REQUEST_START_VALUE;

        for (String currentProperty : propertyToValue.keySet()) {
            if (request.endsWith("?")) {
                request += currentProperty + "=" + propertyToValue.get(currentProperty);

                continue;
            }

            request += "&" + currentProperty + "=" + propertyToValue.get(currentProperty);
        }

        return request;
    }

    public String buildLocationsRequest() {
        request = LOCATIONS_REQUEST_START_VALUE;

        return request;
    }

    private void validateRequest() {
        for (String currentProperty : propertyToValue.keySet()) {
            if (propertyToValue.get(currentProperty) == null) {
                //throw new Exception
            }
        }
    }

    public AeronetRequestBuilder setStartDate(LocalDateTime startDate) {
        propertyToValue.put("year", String.valueOf(startDate.getYear()));
        propertyToValue.put("month", String.valueOf(startDate.getMonthValue()));
        propertyToValue.put("day", String.valueOf(startDate.getDayOfMonth()));
        propertyToValue.put("hour", String.valueOf(startDate.getHour()));

        return this;
    }

    public AeronetRequestBuilder setEndDate(LocalDateTime startDate) {
        propertyToValue.put("year2", String.valueOf(startDate.getYear()));
        propertyToValue.put("month2", String.valueOf(startDate.getMonthValue()));
        propertyToValue.put("day2", String.valueOf(startDate.getDayOfMonth()));
        propertyToValue.put("hour2", String.valueOf(startDate.getHour()));

        return this;
    }

    public AeronetRequestBuilder setSite(String siteName) {
        propertyToValue.put("site", siteName);

        return this;
    }

    public AeronetRequestBuilder setAVG(Integer avg) {
        propertyToValue.put("AVG", String.valueOf(avg));

        return this;
    }

    public AeronetRequestBuilder setIfNoHtml(Boolean ifNoHtml) {
        String ifNotHtmlBinary = (ifNoHtml) ? "1" : "0";
        propertyToValue.put("if_no_html", ifNotHtmlBinary);

        return this;
    }

    public AeronetRequestBuilder setAod(Integer aod) {
        propertyToValue.put("AOD10", String.valueOf(aod));

        return this;
    }

    public static void main(String[] args) {

        System.out.println(LocalDate.now());
        AeronetRequestBuilder builder = new AeronetRequestBuilder();
        //System.out.println(builder.setStartDate(LocalDateTime.now()).setEndDate(LocalDateTime.now()).setAVG(12).setSite("testSite").setIfNoHtml(true));
    }
}
