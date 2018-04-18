package com.example.dao;

import com.example.entities.Location;

import java.util.ArrayList;

public interface LocationDAO {
    public Location getLocationByName(String name);
    public ArrayList<Location> getAllLocations();
    public Boolean insertLocation(Location newLocation);
    public Boolean insertLocations(ArrayList<Location> newLocation);
}
