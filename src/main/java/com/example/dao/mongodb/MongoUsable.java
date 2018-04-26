package com.example.dao.mongodb;

import com.mongodb.BasicDBObject;

public interface MongoUsable {
    public Object toJavaObject(BasicDBObject dbObject);
    public BasicDBObject toDbObject(Object javaObject);
}
