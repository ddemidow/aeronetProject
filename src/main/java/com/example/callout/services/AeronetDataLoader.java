package com.example.callout.services;

import com.example.Utils.Utils;
import com.example.callout.utils.AeronetRequestBuilder;
import com.example.dao.DiscoveryItemDAO;
import com.example.dao.mongodb.DiscoveryItemMongoDAO;
import com.example.dao.mongodb.LocationMongoDAO;
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

            System.out.println(headers[headers.length-1]);

            for (String serializedItem; (serializedItem = reader.readLine()) != null;) {
                String[] serealizedItemValues = serializedItem.split(",");
                HashMap<String, Object> currentDiscoveryItemData = new HashMap<String, Object>();

                for (String currenyHeaderName : headers) {
                    currentDiscoveryItemData.put(currenyHeaderName, null);
                }

                DiscoveryItem newDiscoveryItem = new DiscoveryItem();
                newDiscoveryItem.setFieldToValue(currentDiscoveryItemData);

                for (Integer serializedItemIndex = 0; serializedItemIndex < serealizedItemValues.length; serializedItemIndex++) {
                    if (!serealizedItemValues[serializedItemIndex].equals(Utils.NULLABLE_VALUE)) {
                        if (headers[serializedItemIndex].equals("Day_of_Year")) {
                            System.out.println(serealizedItemValues[serializedItemIndex]);
                        }
                        newDiscoveryItem.setValueToField(headers[serializedItemIndex], serealizedItemValues[serializedItemIndex]);
                    } else {
                        //System.out.println(headers[serializedItemIndex] + " - NULL!!!");
                        newDiscoveryItem.setValueToField(headers[serializedItemIndex], null);
                    }
                }

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

    public Location getLocations(String request, String name) {
        URL endpointUrl = null;

        try {
            endpointUrl = new URL(request);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ArrayList<Location> locations = new ArrayList<Location>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(endpointUrl.openStream(), "UTF-8"))) {
            reader.readLine();
            reader.readLine();

            for (String serealizedlocation; (serealizedlocation = reader.readLine()) != null;) {
                if(deserializeLocation(serealizedlocation).getName().equals(name)) {
                    return deserializeLocation(serealizedlocation);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; //throw exception
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
        String request = builder.setStartDate(LocalDateTime.now().minusYears(18)).setEndDate(LocalDateTime.now().minusYears(18).plusDays(7)).setAVG(20).setSite("Cart_Site").setIfNoHtml(true).setAod(1).buildDiscoveryItemRequest();
        System.out.println(request);

        //https://aeronet.gsfc.nasa.gov/cgi-bin/print_web_data_v3?&if_no_html=1&month2=APRIL&AVG=12&site=Cart_Site&hour2=16&month=APRIL&hour=16&year=2000&day2=20&day=20&year2=2001
       //ArrayList<DiscoveryItem> items = new AeronetDataLoader().getDiscoveryItems(request);

       //System.out.println(Utils.getAverageDiscoveryItem(items));

      /* ArrayList<Location> locations = new AeronetDataLoader().getAllLocations(new AeronetRequestBuilder().buildLocationsRequest());

       System.out.println(locations.size());

       new LocationMongoDAO().insertLocations(locations);*/
      // Double.
        //Utils.getAverageDiscoveryItem(items);

        //DiscoveryItemMongoDAO dao = new DiscoveryItemMongoDAO();
        //System.out.println(dao.insertItems(items, String.valueOf(items.get(0).getFieldToValue().get("AERONET_Site"))));
    }
}

