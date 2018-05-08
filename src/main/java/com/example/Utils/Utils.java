package com.example.Utils;

import com.example.entities.DiscoveryItem;
import com.example.entities.Location;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String MONGO_DB_NAME = "MongoDB";
    public static final String NO_BASE_NAME = "No base";
    public static final String NULLABLE_VALUE = "-999.0";
    public static final String ADD_LOCATION_ENDPOINT = "https://ap5.salesforce.com/services/apexrest/addLocation";

    public static enum DatabaseName {
        MONGO_DB_NAME, NO_BASE_NAME
    }

    public static enum MigrationStatus {
        Completed, Declined, InProgress_Downloading, InProgress_Inserting
    }

    public static void logException(Exception ex) {

    }

    public static DiscoveryItem getAverageDiscoveryItem(ArrayList<DiscoveryItem> discoveryItems) {
        DiscoveryItem averageDiscoveryItem = discoveryItems.get(0);

        for (Integer index = 1; index < discoveryItems.size(); index++) {
            DiscoveryItem currentDiscoveryItem = discoveryItems.get(index);

            for (String currentFieldName : currentDiscoveryItem.getFieldToValue().keySet()) {
                if (currentFieldName.equals("AOD_1020nm")) {
                    System.out.println(currentDiscoveryItem.getValueFromField(currentFieldName));
                }

                if ((currentDiscoveryItem.getValueFromField(currentFieldName) instanceof Double)
                        || currentDiscoveryItem.getValueFromField(currentFieldName) instanceof Integer) {
                    averageDiscoveryItem.setValueToField(currentFieldName, (Double)averageDiscoveryItem.getValueFromField(currentFieldName)
                            + (Double)currentDiscoveryItem.getValueFromField(currentFieldName));
                }
            }
        }

        for (String currentFieldName : averageDiscoveryItem.getFieldToValue().keySet()) {
            if (currentFieldName.equals("AOD_1020nm")) {
                System.out.println(averageDiscoveryItem.getValueFromField(currentFieldName));
            }

            if ((averageDiscoveryItem.getValueFromField(currentFieldName) instanceof Double)
                    || averageDiscoveryItem.getValueFromField(currentFieldName) instanceof Integer) {
                averageDiscoveryItem.setValueToField(currentFieldName, (Double)averageDiscoveryItem.getValueFromField(currentFieldName) / discoveryItems.size());
            }
        }


        System.out.println(averageDiscoveryItem);

        return averageDiscoveryItem;
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

        ObjectMapper mapper = new ObjectMapper();

        //For testing
        //User user = createDummyUser();
        Location l = new Location();
        l.setName("test");
        l.setLatitude(12.4);
        l.setLongitude(34.4);

        try {
            //Convert object to JSON string and save into file directly
            //mapper.writeValue(new File("D:\\user.json"), user);

            //Convert object to JSON string
            //mapper.
            ArrayList<Location> locations = new ArrayList<>();
            locations.add(l);
            String jsonInString = mapper.writeValueAsString(l);
            System.out.println(jsonInString);

            //Convert object to JSON string and pretty print
            //jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            //System.out.println(jsonInString);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public static class Wrapper{
        ArrayList<Location> locationRequest;

        public Wrapper(ArrayList<Location> locationRequest) {
            this.locationRequest = locationRequest;
        }

        public ArrayList<Location> getLocationRequest() {
            return locationRequest;
        }

        public void setLocationRequest(ArrayList<Location> locationRequest) {
            this.locationRequest = locationRequest;
        }
    }
}
