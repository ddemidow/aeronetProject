package com.example.dao;

import com.example.entities.DiscoveryItem;
import com.example.entities.Location;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface DiscoveryItemDAO {
    public ArrayList<DiscoveryItem> getAllItemsFromLocation(String locationName);
    public ArrayList<DiscoveryItem> getAllItemsBetween(LocalDate strartFrom, LocalDate endWith, String locationName);
    public Boolean insertItem(DiscoveryItem newItem, String parentLocation);
    public Boolean insertItems(ArrayList<DiscoveryItem> newItems, String parentLocation);
    public Boolean insertAverageDiscoveryIyem(ArrayList<DiscoveryItem> newAverageItems);
    public ArrayList<DiscoveryItem> getAllAverageItens();
}
