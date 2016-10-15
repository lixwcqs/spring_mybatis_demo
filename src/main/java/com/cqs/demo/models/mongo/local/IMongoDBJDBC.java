package com.cqs.demo.models.mongo.local;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by cqs on 11/2/16.
 */
public interface IMongoDBJDBC {

    MongoDatabase getMongoDB(String dbName);

    MongoCollection<Document> getCollection(String collection);

    MongoCollection<Document> getCollection(String dbName, String collectionName);
}
