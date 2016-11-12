package com.cqs.demo.models.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * 若要写入到指定的Collection中需要通过DBCollection对象操作
 * MongoTemplate直接insert操作的是默认集合(如document)
 * Created by cqs on 11/12/16.
 */
@Component
public class MongoDBTemplateDemo {

    @Resource
    MongoTemplate template;

    private Random random = new Random();

    public void insertByTemplate() {
        System.out.println(template.getDb());
        //插入文档
        /**
         * 1. 创建文档 org.bson.Document 参数为key-value的格式
         * 2. 创建文档集合List<Document>
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
         * */
        Document document = new Document("title2", "MongoDB").
                append("description", "database").
                append("likes2", random.nextInt(100)).
                append("by", "Fly");

        template.getCollection("template");

        template.insert(document);
        System.out.println(template.collectionExists("template"));
    }

    public void insertByCollection() {
        DBCollection collection = this.template.getCollection("news");
        DBObject dbObject = new BasicDBObject();
        dbObject.put("title", "奥巴马政府正式放弃TPP 中国恐成赢家");
        dbObject.put("author", "凤凰国际");
        dbObject.put("publishDate", "2016年11月12日 07:27");
        dbObject.put("content", "据华尔街日报报道，奥巴马政府周五放弃了颁布跨太平洋[2.60% 资金 研报]伙伴关系协定(简称TPP)的所有希望，这一协定旨在保持美国在迅速增长的亚洲的经济影响力，现在被一股随着周二总统大选结果而达到高潮的反贸易政治情绪所葬送。\n" +
                "\n" +
                "在特朗普意外获胜仅仅几天后，美国官员说，国会共和党领导人明确表示，他们在奥巴马任期的剩余时间内不会考虑TPP。\n" +
                "\n" +
                "无法通过这项十多年来最大的贸易协定对奥巴马来说是一个苦涩的挫败，他对自由贸易迟来但热烈的支持令民主党分歧扩大，并对希拉里・克林顿的竞选造成影响。\n" +
                "\n" +
                "TPP的瓦解还打击了美国在泛太平洋地区的威信，与此同时中国正在彰显其经济实力，一些媒体开始预测“中国将成为赢家”。\n" +
                "\n" +
                "媒体预测中国恐成赢家\n" +
                "\n" +
                "《韩国经济》11日的报道称，中国这边传出了与东盟和韩日澳等推动“区域全面经济伙伴关系”(RCEP)谈判的消息。有消息称，在秘鲁召开的APEC非正式领导人会议上，中方将再次推动尽快签署RCEP。有专家认为，随着TPP可能因为美国新总统上台而胎死腹中，亚太国家正将注意力重新转向RCEP，甚至有可能使日本改变态度加入RCEP。\n" +
                "\n" +
                "英国《金融时报》11日称，中国正再次努力推进“抗衡TPP的RCEP”，特朗普的当选使中国得以顺理成章地推动建立亚太自由贸易区。\n" +
                "\n" +
                "《纽约时报》10日称，特朗普带来的不确定性给美国的盟友和对手都带来了压力，较小的国家在美国和崛起的中国之间将面临更艰难选择，“如果美国的支持显得不太有把握，那么中国会变得更有吸引力”。");

        collection.insert(dbObject);
    }

    public void findAll() {
        DBCollection collection = this.template.getCollection("news");//集合news
        collection = this.template.getCollection("document");//默认集合
        //使用Cursor 获取所有文档
        DBCursor cursor = collection.find();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

    public void findOne() {
        DBCollection collection = this.template.getCollection("news");//集合news
        DBObject object = collection.findOne();
        System.out.println(object);

    }
}
