package com.pamartromain.playerbattle.league.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class LeagueDAO {

    @Autowired
    private lateinit var mongoClient: MongoTemplate
}