package com.example.dao.mongodb;

import com.mongodb.DBObject;

public interface MongoExecutable {
    public DBObject toDbObject(Object obj);
}
