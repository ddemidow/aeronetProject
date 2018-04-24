package com.example.Utils;

import com.example.entities.DiscoveryItem;

import java.util.ArrayList;

public class Utils {
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

    public static void main(String[] args) {
        String s = "123.sdf";

        System.out.println(s.toString());
    }
}
