package com.example.dao.mongodb;

import com.example.dao.LocationDAO;
import com.example.entities.Location;
import com.mongodb.*;

import java.util.ArrayList;

public class LocationMongoDAO implements LocationDAO {
    private final String LOCATION_COLLECTION_NAME = "locations";

    private DBCollection locationCollaction;

    public LocationMongoDAO() {
        locationCollaction = new MongoClient().getDB("test").getCollection(LOCATION_COLLECTION_NAME);
    }

    @Override
    public Location getLocationByName(String name) {
        DBCursor cursor = locationCollaction.find(new BasicDBObject("id", name));
        Location locationToFind = null;

        try {
            locationToFind = toJavaObject(cursor.one());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return locationToFind;
    }

    @Override
    public ArrayList<Location> getAllLocations() {
        ArrayList<Location> allLocations = new ArrayList<Location>();
        DBCursor cursor = locationCollaction.find();

        //cursor.one();
        while (cursor.hasNext()) {
            allLocations.add(toJavaObject(cursor.next()));
        }

        return allLocations;
    }

    @Override
    public Boolean insertLocation(Location newLocation) {
        try {
            locationCollaction.insert(toDbObject(newLocation));
        } catch (Exception ex) {
            //log
            return false;
        }

        return true;
    }

    @Override
    public Boolean insertLocations(ArrayList<Location> newLocations) {
        try {
            ArrayList<DBObject> convertedLocations = new ArrayList<DBObject>();

            for (Location currentLocation : newLocations) {
                convertedLocations.add(toDbObject(currentLocation));
            }

            locationCollaction.insert(convertedLocations);
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LocationMongoDAO dao = new LocationMongoDAO();

        /*for (int i = 1; i<10 ; i++) {
            Location newLot = new Location();
            newLot.setName("test" + i);
            newLot.setElevation(1.0);
            newLot.setLongitude(2.0);
            newLot.setLatitude(3.0);
            dao.insertLocation(newLot);
        }*/

        //ArrayList<Location> all = dao.getAllLocations();

        //for (Location currentLocation : all) {
        //System.out.println(dao.getLocationByName("test").getName());
        //}

        //MongoClient mongoClient = new MongoClient();
        //mongoClient.getDB("test1").getCollection("collTest").insert(new BasicDBObject("field", "value"));
    }

    private DBObject toDbObject(Location location) {
        return new BasicDBObject("id", location.getName())
                            .append("latitude", location.getLatitude())
                            .append("longitude", location.getLongitude())
                            .append("elevation", location.getElevation());
    }
    
    private Location toJavaObject(DBObject dbLocation) {
        Location newLocation = new Location();
        
        newLocation.setName((String)dbLocation.get("id"));
        newLocation.setLatitude((Double)dbLocation.get("latitude"));
        newLocation.setLongitude((Double)dbLocation.get("longitude"));
        newLocation.setElevation((Double)dbLocation.get("elevation"));

        return newLocation;
    }
}
