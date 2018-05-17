package com.example.Utils;

import com.example.entities.DiscoveryItem;
import com.example.entities.Location;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Utils {
    public static final String MONGO_DB_NAME = "MongoDB";
    public static final String NO_BASE_NAME = "No base";
    public static final String NULLABLE_VALUE = "-999.";
    public static final String ADD_LOCATION_ENDPOINT = "https://ap5.salesforce.com/services/apexrest/addLocation";
    public static final String ADD_DISCOVERY_ITEM_ENDPOINT = "https://ap5.salesforce.com/services/apexrest/addDiscoveryItems";

    public static enum CalculatedDiscoveryItemType {
        MINIMUM("Minimum"), AVERAGE("Average"), MAXIMUM("Maximum");

        public String sfName;

        CalculatedDiscoveryItemType(String sfNameArg) {
            sfName = sfNameArg;
        }
    }

    public static enum DatabaseName {
        MONGO_DB_NAME, NO_BASE_NAME
    }

    public static enum MigrationStatus {
        Completed, Declined, InProgress_Downloading, InProgress_Inserting
    }

    public static void logException(Exception ex) {

    }

    public static HashMap<CalculatedDiscoveryItemType, DiscoveryItem> getAverageDiscoveryItem(ArrayList<DiscoveryItem> discoveryItems) {
        DiscoveryItem averageDiscoveryItem = new DiscoveryItem(discoveryItems.get(0).getFieldToValue());
        DiscoveryItem maxDiscoveryItem = new DiscoveryItem(discoveryItems.get(0).getFieldToValue());
        DiscoveryItem minDiscoveryItem = new DiscoveryItem(discoveryItems.get(0).getFieldToValue());

        Integer count = 1;

        for (Integer index = 1; index < discoveryItems.size(); index++) {
            DiscoveryItem currentDiscoveryItem = discoveryItems.get(index);

            for (String currentFieldName : currentDiscoveryItem.getAllKeys()) {
                Object value;

                try {
                    value = Integer.valueOf(String.valueOf(currentDiscoveryItem.getValueFromField(currentFieldName)));
                } catch (Exception intEx) {
                    try {
                        value = Double.valueOf(String.valueOf(currentDiscoveryItem.getValueFromField(currentFieldName)));
                    } catch(Exception decEx) {
                        continue;
                    }

                }

                if ((value instanceof Integer) || (value instanceof Double)) {
                    if (value != null) {
                        averageDiscoveryItem.setValueToField(currentFieldName, (Double)averageDiscoveryItem.getValueFromField(currentFieldName)
                                + (Double)currentDiscoveryItem.getValueFromField(currentFieldName));

                        if ((minDiscoveryItem.getValueFromField(currentFieldName) == null && value != null) ||
                                (Double)minDiscoveryItem.getValueFromField(currentFieldName) > (Double)currentDiscoveryItem.getValueFromField(currentFieldName)) {
                            minDiscoveryItem.setValueToField(currentFieldName, currentDiscoveryItem.getValueFromField(currentFieldName));
                        }

                        if ((maxDiscoveryItem.getValueFromField(currentFieldName) == null && value != null) ||
                                (Double)maxDiscoveryItem.getValueFromField(currentFieldName) < (Double)currentDiscoveryItem.getValueFromField(currentFieldName)) {
                            maxDiscoveryItem.setValueToField(currentFieldName, currentDiscoveryItem.getValueFromField(currentFieldName));
                        }
                    } else {
                        averageDiscoveryItem.setValueToField(currentFieldName, (Double)averageDiscoveryItem.getValueFromField(currentFieldName)
                                + (Double)averageDiscoveryItem.getValueFromField(currentFieldName));
                    }
                }
            }

            count++;
        }

        for (String currentFieldName : averageDiscoveryItem.getAllKeys()) {
            if ((averageDiscoveryItem.getValueFromField(currentFieldName) instanceof Double)
                    || averageDiscoveryItem.getValueFromField(currentFieldName) instanceof Integer) {
                averageDiscoveryItem.setValueToField(currentFieldName, (Double)averageDiscoveryItem.getValueFromField(currentFieldName) / count);
            }
        }

        HashMap<CalculatedDiscoveryItemType, DiscoveryItem> calculatedtypeToDiscoveryItem = new HashMap<>();

        calculatedtypeToDiscoveryItem.put(CalculatedDiscoveryItemType.AVERAGE, averageDiscoveryItem);
        calculatedtypeToDiscoveryItem.put(CalculatedDiscoveryItemType.MAXIMUM, maxDiscoveryItem);
        calculatedtypeToDiscoveryItem.put(CalculatedDiscoveryItemType.MINIMUM, minDiscoveryItem);

        return calculatedtypeToDiscoveryItem;
    }

    public static String serializeObjectToJSON(Object objectToSerializing) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;

        try {
            jsonInString = mapper.writeValueAsString(objectToSerializing);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(null));
    }

    public static class LocationWrapper{
        private ArrayList<Location> locationRequest;

        public LocationWrapper(ArrayList<Location> locationRequest) {
            this.locationRequest = locationRequest;
        }

        public ArrayList<Location> getLocationRequest() {
            return locationRequest;
        }

        public void setLocationRequest(ArrayList<Location> locationRequest) {
            this.locationRequest = locationRequest;
        }
    }

    public static class DiscoveryItemsWrapperRequest {
        private ArrayList<DiscoveryItemWrapper> discoveryItemsRequest;

        public DiscoveryItemsWrapperRequest(ArrayList<DiscoveryItemWrapper> discoveryItemsRequest) {
            this.discoveryItemsRequest = discoveryItemsRequest;
        }

        public ArrayList<DiscoveryItemWrapper> getDiscoveryItemsRequest() {
            return discoveryItemsRequest;
        }

        public void setDiscoveryItemsRequest(ArrayList<DiscoveryItemWrapper> discoveryItemsRequest) {
            this.discoveryItemsRequest = discoveryItemsRequest;
        }
    }

    public static class DiscoveryItemWrapper {
        private String data;
        private String type;
        private String location;

        public DiscoveryItemWrapper(DiscoveryItem discoveryItem, CalculatedDiscoveryItemType type, String location) {
            this.data = serializeObjectToJSON(discoveryItem.getFieldToValue());
            this.location = location;
            this.type = type.sfName;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
