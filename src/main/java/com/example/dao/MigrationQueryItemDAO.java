package com.example.dao;

import com.example.callout.controllers.AeronetDataLoadingController;

import java.time.LocalDateTime;

public interface MigrationQueryItemDAO {
    public Boolean insertMigrationQueryItem(AeronetDataLoadingController.MigrationQueryItem migrationQueryItemToInsert);
    public AeronetDataLoadingController.MigrationQueryItem getMigrationQueryItems(LocalDateTime strartDate, LocalDateTime endDate);
    public AeronetDataLoadingController.MigrationQueryItem getMigrationQueryItems(String locationName);
}
