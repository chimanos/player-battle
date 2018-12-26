package com.pamartromain.playerbattle.player.dao

import com.pamartromain.playerbattle.player.entity.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class PlayerDAO {

    @Autowired
    private lateinit var mongoClient: MongoTemplate

    companion object {
        const val PLAYER_COLLECTION_NAME = "player"
    }

    fun addPlayer(player: Player) = mongoClient.insert(player, PLAYER_COLLECTION_NAME)

    fun updatePlayer(player: Player) = mongoClient.save(player, PLAYER_COLLECTION_NAME)

    fun deletePlayer(player: Player) = mongoClient.remove(player, PLAYER_COLLECTION_NAME)

    fun getPlayerById(playerId: String) = mongoClient.findById(playerId, Player::class.java, PLAYER_COLLECTION_NAME)

    fun getPlayerByLoginAndPassword(login: String, password: String): Player? {
        val query = Query()
        query.addCriteria(Criteria.where("login").`is`(login))
        query.addCriteria(Criteria.where("password").`is`(password))
        return mongoClient.findOne(query, Player::class.java, PLAYER_COLLECTION_NAME)
    }
}
