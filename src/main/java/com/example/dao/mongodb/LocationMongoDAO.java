package com.example.dao.mongodb;

import com.example.dao.LocationDAO;
import com.example.entities.Location;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.ArrayList;

public class LocationMongoDAO implements LocationDAO, MongoExecutable {

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

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        mongoClient.getDB("test1").getCollection("collTest").insert(new BasicDBObject("field", "value"));
    }

    @Override
    public DBObject toDbObject(Object obj) {
        return null;
    }
}
