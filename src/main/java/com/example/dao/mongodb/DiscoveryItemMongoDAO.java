package com.example.dao.mongodb;

import com.example.dao.DiscoveryItemDAO;
import com.example.entities.DiscoveryItem;
import com.example.entities.Location;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Date;

public class DiscoveryItemMongoDAO implements DiscoveryItemDAO {

    @Override
    public ArrayList<DiscoveryItem> getAllItemsFromLocation() {
        return null;
    }

    @Override
    public ArrayList<DiscoveryItem> getAllItemsBetween(Date strartFrom, Date endWith) {
        return null;
    }

    @Override
    public Boolean insertItem(DiscoveryItem newItem, Location parentLocation) {
        return null;
    }

    @Override
    public Boolean insertItems(ArrayList<DiscoveryItem> newItems, Location parentLocation) {
        return null;
    }

    public DBObject toDbObject(DiscoveryItem item) {
        BasicDBObject dbDiscoveryItem = new BasicDBObject();

        for (String currentFieldName : item.getFieldToValue().keySet()) {
            dbDiscoveryItem.append(currentFieldName, item.getFieldToValue().get(currentFieldName));
        }

        return dbDiscoveryItem;
    }

    public DiscoveryItem toJavaObject(DBObject dbDiscoveryItem) {
        return null;
    }
}
