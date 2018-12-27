package com.pamartromain.playerbattle.league.ressource

import com.pamartromain.playerbattle.league.service.LeagueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("league")
class LeagueRessource {

    @Autowired
    private lateinit var leagueService: LeagueService

    @PostMapping("/{name}")
    fun createLeague(@PathVariable(value = "name") name: String) = leagueService.createLeague(name)

    @GetMapping
    fun getAllLeagues() = leagueService.getAllLeagues()

    @GetMapping("/{leagueId}")
    fun getLeagueById(@PathVariable(value = "leagueId") leagueId: String) = leagueService.getLeagueById(leagueId)

    @PostMapping("/{leagueId}/{playerId}")
    fun addPlayerToLeague(@PathVariable(value = "leagueId") leagueId: String, @PathVariable(value = "playerId") playerId: String) = leagueService.addPlayerToLeague(leagueId, playerId)

    @DeleteMapping("/{playerId}")
    fun exitLeague(@PathVariable(value = "playerId") playerId: String) = leagueService.exitLeague(playerId)
}