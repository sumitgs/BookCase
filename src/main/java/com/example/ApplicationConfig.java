package com.example;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by sumit.suthar on 20/1/16.
 */
public class ApplicationConfig extends AbstractMongoConfiguration {
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "springdata";
    }
}
