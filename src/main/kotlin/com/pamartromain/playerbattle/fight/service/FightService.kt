package com.pamartromain.playerbattle.fight.service

import com.pamartromain.playerbattle.character.entity.Character
import com.pamartromain.playerbattle.fight.entity.Fight
import com.pamartromain.playerbattle.player.entity.Player
import com.pamartromain.playerbattle.player.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.text.DateFormat
import java.util.*


@Service
class FightService {

    @Autowired
    private lateinit var playerService: PlayerService

    fun fight(characterOneId: String, characterTwoId: String, playerId: String): Player? {
        val player = playerService.getPlayerById(playerId)

        var characterOne: Character? = null
        var characterTwo: Character? = null

        player!!.characters!!.forEach {
            if(characterOneId == it.characterId) {
                characterOne = it
            }

            if(characterTwoId == it.characterId) {
                characterTwo = it
            }
        }

        val randomOne = getRandom(0, characterOne!!.score)
        val randomTwo = getRandom(0, characterTwo!!.score)

        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val date = Date()
        val currentDate = dateFormat.format(date)

        var fight: Fight? = null

        /*
            Je fais des trucs pas trés propre car je n'ai plus beaucoup de temps
         */
        if(randomOne > randomTwo) {
            fight = Fight("${date.time}${UUID.randomUUID()}",
                    "${characterOne!!.name} (${characterOne!!.score})",
                    "${characterTwo!!.name} (${characterTwo!!.score})",
                    currentDate,
                    characterOne!!.name)
        } else {
            fight = Fight("${date.time}${UUID.randomUUID()}",
                    "${characterOne!!.name} (${characterOne!!.score})",
                    "${characterTwo!!.name} (${characterTwo!!.score})",
                    currentDate,
                    characterTwo!!.name)
        }

        if(player!!.fights != null) {
            player.fights!!.add(fight)
        } else {
            player!!.fights = ArrayList<Fight>()
            player.fights!!.add(fight)
        }

        playerService.updatePlayer(player)

        return player
    }

    private fun getRandom(min: Int, max: Int): Int {
        val rand = Random()
        return min + rand.nextInt((max - min) + 1)
    }
}