package com.pamartromain.playerbattle.player.service

import com.pamartromain.playerbattle.character.entity.Character
import com.pamartromain.playerbattle.global.LoginBody
import com.pamartromain.playerbattle.player.dao.PlayerDAO
import com.pamartromain.playerbattle.player.entity.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerService {

    @Autowired
    private lateinit var playerDAO: PlayerDAO

    fun addPlayer(loginBody: LoginBody) {
        val player = Player("${loginBody.login}${UUID.randomUUID()}", loginBody.login, loginBody.password, 10000, null, null)
        playerDAO.addPlayer(player)
    }

    fun updatePlayer(player: Player) = playerDAO.updatePlayer(player)

    fun deletePlayer(player: Player) = playerDAO.deletePlayer(player)

    fun getPlayerById(playerId: String) = playerDAO.getPlayerById(playerId)

    fun login(loginBody: LoginBody) = playerDAO.getPlayerByLoginAndPassword(loginBody.login, loginBody.password)
}