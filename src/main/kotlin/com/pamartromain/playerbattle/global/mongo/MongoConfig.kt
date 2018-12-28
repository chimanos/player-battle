package com.pamartromain.playerbattle.global.mongo

import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.ServerAddress
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoDbFactory

@Configuration
class MongoConfig {

    private fun mongo(): SimpleMongoDbFactory {
        val serverAddress = ServerAddress("morty.ovh", 27017)
        val mongoClientOptions = MongoClientOptions.builder()
        val mongoClient = MongoClient(serverAddress, mongoClientOptions.build())

        return SimpleMongoDbFactory(mongoClient, "playerbattle")
    }

    @Bean()
    fun mongoClient(): MongoTemplate = MongoTemplate(mongo())
}