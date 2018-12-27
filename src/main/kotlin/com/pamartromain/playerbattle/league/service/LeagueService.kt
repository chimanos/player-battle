package com.pamartromain.playerbattle.league.service

import com.pamartromain.playerbattle.league.dao.LeagueDAO
import com.pamartromain.playerbattle.league.entity.League
import com.pamartromain.playerbattle.player.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LeagueService {

    @Autowired
    private lateinit var leagueDAO: LeagueDAO

    @Autowired
    private lateinit var playerService: PlayerService

    fun createLeague(name: String) {
        val league = League("$name${UUID.randomUUID()}", name, 0)
        leagueDAO.addLeague(league)
    }

    fun getLeagueById(leagueId: String) = leagueDAO.getLeagueById(leagueId)

    fun deleteLeague(league: League) = leagueDAO.deleteLeague(league)

    fun getAllLeagues() = leagueDAO.getAllLeagues()

    fun addPlayerToLeague(leagueId: String, playerId: String) {
        val player = playerService.getPlayerById(playerId)
        val league = leagueDAO.getLeagueById(leagueId)

        league!!.nbPlayer++
        leagueDAO.updateLeague(league)

        player!!.leagueId = leagueId
        playerService.updatePlayer(player)
    }

    fun exitLeague(playerId: String) {
        val player = playerService.getPlayerById(playerId)
        val league = leagueDAO.getLeagueById(player!!.leagueId!!)

        league!!.nbPlayer--
        leagueDAO.updateLeague(league)

        player!!.leagueId = null
        playerService.updatePlayer(player)
    }
}