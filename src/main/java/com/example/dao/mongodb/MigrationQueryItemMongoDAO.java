package com.example.dao.mongodb;

import com.example.callout.controllers.AeronetDataLoadingController;
import com.example.dao.MigrationQueryItemDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.time.LocalDateTime;

public class MigrationQueryItemMongoDAO implements MigrationQueryItemDAO, MongoUsable{
    private final String MIGRATION_ITEM_COLLECTION_NAME = "migrationitems";

    private MongoClient mongoClient;
    private DBCollection migrationItemCollection;

    public MigrationQueryItemMongoDAO() {
        mongoClient = new MongoClient();
        migrationItemCollection.getCollection(MIGRATION_ITEM_COLLECTION_NAME);
    }

    @Override
    public Boolean insertMigrationQueryItem(AeronetDataLoadingController.MigrationQueryItem migrationQueryItemToInsert) {
        return null;
    }

    @Override
    public AeronetDataLoadingController.MigrationQueryItem getMigrationQueryItems(LocalDateTime strartDate, LocalDateTime endDate) {
        return null;
    }

    @Override
    public AeronetDataLoadingController.MigrationQueryItem getMigrationQueryItems(String locationName) {
        return null;
    }

    @Override
    public MigrationQueryItemDAO toJavaObject(BasicDBObject dbObject) {
        return null;
    }

    @Override
    public BasicDBObject toDbObject(Object javaObject) {
        return null;
    }
}
