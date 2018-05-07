package com.example.Utils;

import com.example.entities.DiscoveryItem;
import com.sforce.ws.ConnectorConfig;

import java.util.ArrayList;

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


        //System.out.println(averageDiscoveryItem);

        return averageDiscoveryItem;
    }

    public static void main(String[] args) {
        boolean success = false;
        String username = "username";
        String password = "password";
        String authEndPoint = "https://login.salesforce.com/services/Soap/c/24.0/";

        try {
            ConnectorConfig config = new ConnectorConfig();
            config.setUsername(username);
            config.setPassword(password);

            System.out.println("AuthEndPoint: " + authEndPoint);
            config.setAuthEndpoint(authEndPoint);

            EnterpriseConnection connection = new EnterpriseConnection(config);

            // Print user and session info
            GetUserInfoResult userInfo = connection.getUserInfo();
            System.out.println("UserID: " + userInfo.getUserId());
            System.out.println("User Full Name: " + userInfo.getUserFullName());
            System.out.println("User Email: " + userInfo.getUserEmail());
            System.out.println();
            System.out.println("SessionID: " + config.getSessionId());
            System.out.println("Auth End Point: " + config.getAuthEndpoint());
            System.out
                    .println("Service End Point: " + config.getServiceEndpoint());
            System.out.println();

            success = true;
        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }

        return success;
    }
}
