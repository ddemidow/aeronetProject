package com.example.dao.mongodb;

import com.example.dao.DiscoveryItemDAO;
import com.example.entities.DiscoveryItem;
import com.example.entities.Location;

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
}
