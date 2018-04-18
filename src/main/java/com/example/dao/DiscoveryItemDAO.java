package com.example.dao;

import com.example.entities.DiscoveryItem;

import java.util.ArrayList;
import java.util.Date;

public interface DiscoveryItemDAO {
    public ArrayList<DiscoveryItem> getAllItemsFromLocation();
    public ArrayList<DiscoveryItem> getAllItemsBetween(Date strartFrom, Date endWith);
    public Boolean insertItem()

}
