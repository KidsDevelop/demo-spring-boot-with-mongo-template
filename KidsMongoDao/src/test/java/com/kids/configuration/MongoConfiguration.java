package com.kids.dao.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfiguration {

    @Autowired
    private Environment environment;

    @Primary
    @Bean(name = "mongo")
    public MongoClient mongoClient() {
        return new MongoClient(environment.getRequiredProperty("mongodb.host.main"), Integer.valueOf(environment.getRequiredProperty("mongodb.port.main")));
    }

    @Primary
    @Bean(name = "mongoDbFac")
    public MongoDbFactory mongoDbFactory(@Qualifier("mongo") MongoClient mongoClient) {
        return new SimpleMongoDbFactory(mongoClient, environment.getRequiredProperty("mongodb.database.main"));
    }

    @Primary
    @Bean(name = "mongoTemp")
    public MongoTemplate mongoTemplate(@Qualifier("mongoDbFac") MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }

}
