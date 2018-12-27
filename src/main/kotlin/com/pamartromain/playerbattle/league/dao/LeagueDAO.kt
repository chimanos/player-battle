package com.pamartromain.playerbattle.league.dao

import com.pamartromain.playerbattle.league.entity.League
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class LeagueDAO {

    @Autowired
    private lateinit var mongoClient: MongoTemplate

    companion object {
        const val LEAGUE_COLLECTION_NAME = "league"
    }

    fun addLeague(league: League) = mongoClient.insert(league, LEAGUE_COLLECTION_NAME)

    fun updateLeague(league: League) = mongoClient.save(league, LEAGUE_COLLECTION_NAME)

    fun deleteLeague(league: League) = mongoClient.remove(league, LEAGUE_COLLECTION_NAME)

    fun getLeagueById(leagueId: String) = mongoClient.findById(leagueId, League::class.java, LEAGUE_COLLECTION_NAME)

    fun getAllLeagues() = mongoClient.findAll(League::class.java, LEAGUE_COLLECTION_NAME)
}