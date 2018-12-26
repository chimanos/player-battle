package com.pamartromain.playerbattle.player.service

import com.pamartromain.playerbattle.global.LoginBody
import com.pamartromain.playerbattle.player.dao.PlayerDAO
import com.pamartromain.playerbattle.player.entity.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService {

    @Autowired
    private lateinit var playerDAO: PlayerDAO

    fun addPlayer(player: Player) = playerDAO.addPlayer(player)

    fun updatePlayer(player: Player) = playerDAO.updatePlayer(player)

    fun deletePlayer(player: Player) = playerDAO.deletePlayer(player)

    fun getPlayerById(playerId: String) = playerDAO.getPlayerById(playerId)

    fun login(loginBody: LoginBody) = playerDAO.getPlayerByLoginAndPassword(loginBody.login, loginBody.password)
}