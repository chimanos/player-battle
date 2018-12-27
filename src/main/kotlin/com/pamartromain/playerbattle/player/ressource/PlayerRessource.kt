package com.pamartromain.playerbattle.player.ressource

import com.pamartromain.playerbattle.global.LoginBody
import com.pamartromain.playerbattle.player.entity.Player
import com.pamartromain.playerbattle.player.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("player")
class PlayerRessource {

    @Autowired
    private lateinit var playerService: PlayerService

    @PostMapping()
    fun addPlayer(@RequestBody loginBody: LoginBody) = playerService.addPlayer(loginBody)

    @PutMapping
    fun updatePlayer(@RequestBody player: Player) = playerService.updatePlayer(player)

    @DeleteMapping
    fun deletePlayer(@RequestBody player: Player) = playerService.deletePlayer(player)

    @GetMapping("/{playerId}")
    fun getPlayerById(@PathVariable(value = "playerId") playerId: String) = playerService.getPlayerById(playerId)

    @PostMapping("/login")
    fun login(@RequestBody loginBody: LoginBody): ResponseEntity<Player> {
        val player = playerService.login(loginBody)

        if(player != null) {
            return ResponseEntity(player, HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}