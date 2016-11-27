package com.cqs.demo.models.mongo.local;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqs on 11/2/16.
 */
public class MongoDemo {
    private static IMongoDBJDBC mongoDBJDBC = new MongoDBJDBC("demo");


    public void insertOne() {
        MongoCollection<Document> collection = mongoDBJDBC.getCollection("col_1");
        System.out.println("集合 test 选择成功");
        //插入文档
        /**
         * 1. 创建文档 org.bson.Document 参数为key-value的格式
         * 2. 创建文档集合List<Document>
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
         * */
        Document document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        List<Document> documents = new ArrayList<>();
        documents.add(document);
        collection.insertMany(documents);
        System.out.println("文档插入成功");
    }

    public void findAll() {
        MongoCollection<Document> movie = mongoDBJDBC.getCollection("movie");
        FindIterable<Document> findIterable = movie.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }

    public static void main(String[] args) {
        MongoDemo demo = new MongoDemo();
        demo.insertOne();
    }

}
