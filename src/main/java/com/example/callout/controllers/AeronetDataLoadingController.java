package com.example.callout.controllers;

import com.example.Utils.Utils;
import com.example.callout.services.AeronetDataLoader;
import com.example.callout.utils.AeronetRequestBuilder;
import com.example.dao.DiscoveryItemDAO;
import com.example.dao.LocationDAO;
import com.example.dao.mongodb.DiscoveryItemMongoDAO;
import com.example.dao.mongodb.LocationMongoDAO;
import com.example.entities.DiscoveryItem;
import com.example.entities.Location;
import com.example.exceptions.DatabaseNotSupportException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AeronetDataLoadingController {
	private LocationDAO locationDaoService;
	private DiscoveryItemDAO discoveryItemDaoService;
	private AeronetDataLoader aeronetDataLoader;
	private AeronetRequestBuilder aeronetRequestBuilder;
	private String databaseType;

	public AeronetDataLoadingController(String dbName) throws DatabaseNotSupportException {
		if (dbName.equals(Utils.MONGO_DB_NAME)) {
			databaseType = Utils.MONGO_DB_NAME;
		    locationDaoService = new LocationMongoDAO();
		    discoveryItemDaoService = new DiscoveryItemMongoDAO();
		    aeronetDataLoader = new AeronetDataLoader();
		    aeronetRequestBuilder = new AeronetRequestBuilder();
		} else {
			throw new DatabaseNotSupportException();
		}
	}

	public MigrationQueryItem startProcessDiscoveryData(Location location, LocalDateTime start, LocalDateTime end) {
		MigrationQueryItem queryItem = new MigrationQueryItem();

		queryItem.setStartExecution(LocalDateTime.now());
		queryItem.setStatus(Utils.MigrationStatus.InProgress_Downloading);
		queryItem.setLocationName(location.getName());
		queryItem.setStart(start);
		queryItem.setEnd(end);

		String url = aeronetRequestBuilder.setSite(location.getName()).setStartDate(start).setEndDate(end).setAVG(1).setAod(20).setIfNoHtml(true).buildDiscoveryItemRequest();

		try{
			System.out.println("start downloading...");

			ArrayList<DiscoveryItem> discoveryItemsFromLocation =  aeronetDataLoader.getDiscoveryItems(url);

			queryItem.setSize(discoveryItemsFromLocation.size());
			queryItem.setStatus(Utils.MigrationStatus.InProgress_Inserting);

			System.out.println("start insering...");

			if (databaseType.equals(Utils.MONGO_DB_NAME)) {
				Boolean result = discoveryItemDaoService.insertItems(discoveryItemsFromLocation, location.getName());

				if (result) {
					queryItem.setStatus(Utils.MigrationStatus.Completed);
					queryItem.setDuration((int)Duration.between(LocalDate.now(), queryItem.getStartExecution()).getSeconds());
				}
			}
		} catch(Exception ex) {
			queryItem.setStatus(Utils.MigrationStatus.Declined);
			queryItem.setMessage(ex.getMessage());
		}

		return null;
	}

	public class MigrationQueryItem {
	    private String locationName;
	    private LocalDateTime start;
	    private LocalDateTime end;
		private LocalDateTime startExecution;
		private Integer durationSec;
        private Utils.MigrationStatus status;
        private String message;
        private Integer size;

		public String getLocationName() {
			return locationName;
		}

		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}

		public LocalDateTime getStart() {
			return start;
		}

		public void setStart(LocalDateTime start) {
			this.start = start;
		}

		public LocalDateTime getEnd() {
			return end;
		}

		public void setEnd(LocalDateTime end) {
			this.end = end;
		}

		public Utils.MigrationStatus getStatus() {
			return status;
		}

		public void setStatus(Utils.MigrationStatus status) {
			this.status = status;
		}

		public Integer getSize() {
			return size;
		}

		public void setSize(Integer size) {
			this.size = size;
		}

		public LocalDateTime getStartExecution() {
			return startExecution;
		}

		public void setStartExecution(LocalDateTime startExecution) {
			this.startExecution = startExecution;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Integer getDuration() {
			return durationSec;
		}

		public void setDuration(Integer durationSec) {
			this.durationSec = durationSec;
		}

		@Override
		public String toString() {
			return "MigrationQueryItem{" +
					"locationName='" + locationName + '\'' +
					", start=" + start +
					", end=" + end +
					", startExecution=" + startExecution +
					", durationSec=" + durationSec +
					", status=" + status +
					", message='" + message + '\'' +
					", size=" + size +
					'}';
		}
	}

	public static void main(String[] args) {
		LocationMongoDAO locationDao = new LocationMongoDAO();

		Location test = locationDao.getLocationByName("Lille");

		try {
			AeronetDataLoadingController controller = new AeronetDataLoadingController(Utils.MONGO_DB_NAME);

			MigrationQueryItem item = controller.startProcessDiscoveryData(test, LocalDateTime.now().minusYears(18), LocalDateTime.now().minusYears(18).plusMonths(1));
		} catch (DatabaseNotSupportException e) {
			e.printStackTrace();
		}
	}
}
