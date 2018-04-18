package com.example.dao;

import com.example.entities.DiscoveryItem;
import com.example.entities.Location;

import java.util.ArrayList;
import java.util.Date;

public interface DiscoveryItemDAO {
    public ArrayList<DiscoveryItem> getAllItemsFromLocation();
    public ArrayList<DiscoveryItem> getAllItemsBetween(Date strartFrom, Date endWith);
    public Boolean insertItem(DiscoveryItem newItem, Location parentLocation);
    public Boolean insertItems(ArrayList<DiscoveryItem> newItems, Location parentLocation);
}
