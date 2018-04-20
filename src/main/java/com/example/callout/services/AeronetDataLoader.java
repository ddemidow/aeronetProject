package com.example.callout.services;

import com.example.callout.utils.AeronetRequestBuilder;
import com.example.entities.DiscoveryItem;
import com.example.entities.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class AeronetDataLoader {
    public ArrayList<DiscoveryItem> getDiscoveryItems(String request) {
        URL endpointUrl = null;

        try {
            endpointUrl = new URL(request);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ArrayList<DiscoveryItem> newDiscoveryItems = new ArrayList<DiscoveryItem>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(endpointUrl.openStream(), "UTF-8"))) {
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();

            String[] headers = reader.readLine().split(",");

            for (String serializedItem; (serializedItem = reader.readLine()) != null;) {
                String[] serealizedItemValues = serializedItem.split(",");
                HashMap<String, Object> currentDiscoveryItemData = new HashMap<String, Object>();

                DiscoveryItem newDiscoveryItem = new DiscoveryItem();

                for (Integer serializedItemIndex = 0; serializedItemIndex < serealizedItemValues.length; serializedItemIndex++) {
                    currentDiscoveryItemData.put(headers[serializedItemIndex], serealizedItemValues[serializedItemIndex]);
                }

                newDiscoveryItem.setFieldToValue(currentDiscoveryItemData);
                newDiscoveryItems.add(newDiscoveryItem);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newDiscoveryItems;
    }

    public ArrayList<Location> getAllLocations(String request) {
        URL endpointUrl = null;

        try {
            endpointUrl = new URL(request);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ArrayList<Location> newLocations = new ArrayList<Location>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(endpointUrl.openStream(), "UTF-8"))) {
            reader.readLine();
            reader.readLine();

            for (String serealizedlocation; (serealizedlocation = reader.readLine()) != null;) {
                newLocations.add(deserializeLocation(serealizedlocation));
                //System.out.println("TEST -- " + serealizedlocation);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newLocations;
    }

    private Location deserializeLocation(String serializedLocation) {
        Location newLocation = new Location();

        String [] values = serializedLocation.split(",");
        newLocation.setName(values[0]);
        newLocation.setLongitude(Double.valueOf(values[1]));
        newLocation.setLatitude(Double.valueOf(values[2]));
        newLocation.setElevation(Double.valueOf(values[3]));

        return newLocation;
    }

    public static void main(String[] args) {
        AeronetRequestBuilder builder = new AeronetRequestBuilder();
        String request = builder.setStartDate(LocalDateTime.now().minusYears(18)).setEndDate(LocalDateTime.now().minusYears(17)).setAVG(20).setSite("Cart_Site").setIfNoHtml(true).setAod(1).buildDiscoveryItemRequest();
        System.out.println(request);
        //https://aeronet.gsfc.nasa.gov/cgi-bin/print_web_data_v3?&if_no_html=1&month2=APRIL&AVG=12&site=Cart_Site&hour2=16&month=APRIL&hour=16&year=2000&day2=20&day=20&year2=2001
        System.out.println(new AeronetDataLoader().getDiscoveryItems(request).size());
    }
}
