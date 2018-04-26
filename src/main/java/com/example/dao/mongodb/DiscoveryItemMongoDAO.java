package com.example.dao.mongodb;

import com.example.dao.DiscoveryItemDAO;
import com.example.entities.DiscoveryItem;
import com.example.entities.Location;
import com.mongodb.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class DiscoveryItemMongoDAO implements DiscoveryItemDAO {
    private DBCollection discoveryItemCollection;
    private MongoClient mongoClient;

    public DiscoveryItemMongoDAO() {
        mongoClient = new MongoClient();
    }

    @Override
    public ArrayList<DiscoveryItem> getAllItemsFromLocation(String locationName) {
        discoveryItemCollection = mongoClient.getDB("test").getCollection(locationName);

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
        discoveryItemCollection = mongoClient.getDB("test").getCollection(locationName);

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
        discoveryItemCollection = mongoClient.getDB("test").getCollection(parentLocation);

        try {
            discoveryItemCollection.insert(toDbObject(newItem));

            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Boolean insertItems(ArrayList<DiscoveryItem> newItems, String parentLocation) {
        discoveryItemCollection = mongoClient.getDB("test").getCollection(parentLocation);
        HashMap<String, DBObject> idToconvertedDiscoveryItem = new HashMap<>();

        for (DiscoveryItem currentDiscoveryItem : newItems) {
            idToconvertedDiscoveryItem.put(generateId(currentDiscoveryItem), toDbObject(currentDiscoveryItem));
        }

        System.out.println("finish convering");

        try {
            for (String currentDbObjectId : idToconvertedDiscoveryItem.keySet()) {
                WriteResult writeResult = discoveryItemCollection.update(new BasicDBObject().append("_id", currentDbObjectId), idToconvertedDiscoveryItem.get(currentDbObjectId), true, false);
                System.out.println(writeResult.getN());
                System.out.println(writeResult.isUpdateOfExisting());
            }
            //WriteResult writeResult = discoveryItemCollection.up(convertedDiscoveryItems);

            //System.out.println(writeResult.getN());
           // System.out.println(writeResult.isUpdateOfExisting());

            System.out.println("finish inserting");
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean insertAverageDiscoveryIyem(ArrayList<DiscoveryItem> newAverageItems) {
        discoveryItemCollection = mongoClient.getDB("test").getCollection("averageitems");

        ArrayList<DBObject> convertedDiscoveryItems = new ArrayList<>();

        for (DiscoveryItem currentDiscoveryItem : newAverageItems) {
            convertedDiscoveryItems.add(toDbObject(currentDiscoveryItem));
        }

        try {
            WriteResult writeResult = discoveryItemCollection.insert(convertedDiscoveryItems);

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
        dbDiscoveryItem.append("_id", generateId(item));

        for (String currentFieldName : item.getFieldToValue().keySet()) {
            dbDiscoveryItem.append(currentFieldName, item.getFieldToValue().get(currentFieldName));
        }

        return dbDiscoveryItem;
    }

    private String generateId(DiscoveryItem discoveryItem) {
        return discoveryItem.getValueFromField("Date(dd:mm:yyyy)") + discoveryItem.getValueFromField("Time(hh:mm:ss)").toString();
    }

    public DiscoveryItem toJavaObject(DBObject dbDiscoveryItem) {
        DiscoveryItem discoveryItem = new DiscoveryItem();

        for (String currentFieldName : dbDiscoveryItem.keySet()) {
            discoveryItem.getFieldToValue().put(currentFieldName, dbDiscoveryItem.get(currentFieldName));
        }

        return discoveryItem;
    }
}
