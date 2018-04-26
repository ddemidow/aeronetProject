package com.example.dao.mongodb;

import com.example.dao.DiscoveryItemDAO;
import com.example.entities.DiscoveryItem;
import com.example.entities.Location;
import com.mongodb.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DiscoveryItemMongoDAO implements DiscoveryItemDAO {
    private DBCollection discoveryItemCollection;

    @Override
    public ArrayList<DiscoveryItem> getAllItemsFromLocation(String locationName) {
        discoveryItemCollection = new MongoClient().getDB("test").getCollection(locationName);

        ArrayList<DiscoveryItem> discoveryItems = new ArrayList<DiscoveryItem>();

        DBObject discoveryItemLooksLikeModel = new BasicDBObject("AERONET_Site", locationName);
        DBCursor cursor = discoveryItemCollection.find(discoveryItemLooksLikeModel);

        while (cursor.hasNext()) {
            discoveryItems.add(toJavaObject(cursor.next()));
        }

        return discoveryItems;
    }

    @Override
    public ArrayList<DiscoveryItem> getAllItemsBetween(LocalDate startFrom, LocalDate endWith, String locationName) {
        discoveryItemCollection = new MongoClient().getDB("test").getCollection(locationName);

        ArrayList<DiscoveryItem> discoveryItems = new ArrayList<DiscoveryItem>();
        DBObject discoveryItemLooksLikeModel = new BasicDBObject("AERONET_Site", locationName);
        discoveryItemLooksLikeModel.put("Date(dd:mm:yyyy)", BasicDBObjectBuilder.start("$gte", startFrom).add("$lte", endWith).get());

        DBCursor cursor = discoveryItemCollection.find(discoveryItemLooksLikeModel);

        while (cursor.hasNext()) {
            discoveryItems.add(toJavaObject(cursor.next()));
        }

        return discoveryItems;
    }

    @Override
    public Boolean insertItem(DiscoveryItem newItem, String parentLocation) {
        discoveryItemCollection = new MongoClient().getDB("test").getCollection(parentLocation);

        try {
            discoveryItemCollection.insert(toDbObject(newItem));

            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Boolean insertItems(ArrayList<DiscoveryItem> newItems, String parentLocation) {
        discoveryItemCollection = new MongoClient().getDB("test").getCollection(parentLocation);
        ArrayList<DBObject> convertedDiscoveryItems = new ArrayList<>();

        for (DiscoveryItem currentDiscoveryItem : newItems) {
            convertedDiscoveryItems.add(toDbObject(currentDiscoveryItem));
        }

        try {
            discoveryItemCollection.insert(convertedDiscoveryItems);

            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Boolean insertAverageDiscoveryIyem(ArrayList<DiscoveryItem> newAverageItems) {
        discoveryItemCollection = new MongoClient().getDB("test").getCollection("averageitems");

        ArrayList<DBObject> convertedDiscoveryItems = new ArrayList<>();

        for (DiscoveryItem currentDiscoveryItem : newAverageItems) {
            convertedDiscoveryItems.add(toDbObject(currentDiscoveryItem));
        }

        try {
            discoveryItemCollection.insert(convertedDiscoveryItems);

            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    @Override
    public ArrayList<DiscoveryItem> getAllAverageItens() {
        discoveryItemCollection = new MongoClient().getDB("test").getCollection("averageitems");

        ArrayList<DiscoveryItem> discoveryItems = new ArrayList<DiscoveryItem>();
        DBCursor cursor = discoveryItemCollection.find();

        while (cursor.hasNext()) {
            discoveryItems.add(toJavaObject(cursor.next()));
        }

        return discoveryItems;
    }

    public DBObject toDbObject(DiscoveryItem item) {
        BasicDBObject dbDiscoveryItem = new BasicDBObject();

        for (String currentFieldName : item.getFieldToValue().keySet()) {
            dbDiscoveryItem.append(currentFieldName, item.getFieldToValue().get(currentFieldName));
        }

        return dbDiscoveryItem;
    }

    public DiscoveryItem toJavaObject(DBObject dbDiscoveryItem) {
        DiscoveryItem discoveryItem = new DiscoveryItem();

        for (String currentFieldName : dbDiscoveryItem.keySet()) {
            discoveryItem.getFieldToValue().put(currentFieldName, dbDiscoveryItem.get(currentFieldName));
        }

        return discoveryItem;
    }
}
