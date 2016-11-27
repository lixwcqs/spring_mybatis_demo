package com.cqs.demo.models.mongo.local;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by cqs on 11/2/16.
 */
public class MongoDBJDBC implements IMongoDBJDBC {
    private static MongoClient mongoClient = new MongoClient("localhost", 27017);//连接到 mongodb 服务

    private final String dbName;

    public MongoDBJDBC(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public MongoDatabase getMongoDB(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    @Override
    public MongoCollection<Document> getCollection(String collection) {
        return getMongoDB(dbName).getCollection(collection);
    }

    @Override
    public MongoCollection<Document> getCollection(String dbName, String collectionName) {
        return getMongoDB(dbName).getCollection(collectionName);
    }
}