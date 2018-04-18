package com.example.dao.mongodb;

import com.example.dao.LocationDAO;
import com.example.entities.Location;

import java.util.ArrayList;

public class LocationMongoDAO implements LocationDAO {

    @Override
    public Location getLocationByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Location> getAllLocations() {
        return null;
    }

    @Override
    public Boolean insertLocation(Location newLocation) {
        return null;
    }

    @Override
    public Boolean insertLocations(ArrayList<Location> newLocation) {
        return null;
    }
}
