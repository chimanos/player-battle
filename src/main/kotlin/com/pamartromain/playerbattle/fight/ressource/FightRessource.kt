package com.pamartromain.playerbattle.fight.ressource

import com.pamartromain.playerbattle.fight.service.FightService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("fight")
class FightRessource {

    @Autowired
    private lateinit var fightService: FightService

    @PostMapping("/{characterOneId}/{characterTwoId}/{playerId}")
    fun fight(@PathVariable(value = "characterOneId") characterOneId: String,
              @PathVariable(value = "characterTwoId") characterTwoId: String,
              @PathVariable(value = "playerId") playerId: String) = fightService.fight(characterOneId, characterTwoId, playerId)
}