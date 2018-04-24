package com.example.callout.controllers;

import com.example.Utils.Utils;
import com.example.callout.services.AeronetDataLoader;
import com.example.callout.utils.AeronetRequestBuilder;
import com.example.dao.DiscoveryItemDAO;
import com.example.dao.LocationDAO;
import com.example.dao.mongodb.DiscoveryItemMongoDAO;
import com.example.dao.mongodb.LocationMongoDAO;
import com.example.entities.DiscoveryItem;

import java.time.LocalDate;

public class AeronetDataLoadingController {
	private LocationDAO locationDaoService;
	private DiscoveryItemDAO discoveryItemDaoService;
	private AeronetDataLoader aeronetDataLoader;
	private AeronetRequestBuilder aeronetRequestBuilder;

	public AeronetDataLoadingController(String dbName) {
		if (dbName.equals(Utils.MONGO_DB_NAME)) {
		    locationDaoService = new LocationMongoDAO();
		    discoveryItemDaoService = new DiscoveryItemMongoDAO();
		    aeronetDataLoader = new AeronetDataLoader();
		    aeronetRequestBuilder = new AeronetRequestBuilder();
		} else {
			//throw exception
		}
	}

	public class MigrationQueryItem {
	    private String locationName;
	    private LocalDate start;
	    private LocalDate end;
        private Utils.MigrationStatus status;
    }
}
