package com.pamartromain.playerbattle.character.service

import com.pamartromain.playerbattle.character.entity.Character
import com.pamartromain.playerbattle.player.entity.Player
import com.pamartromain.playerbattle.player.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class CharacterService {

    @Autowired
    private lateinit var playerService: PlayerService

    fun addCharacter(name: String, score: Int, playerId: String): Player? {
        val player = playerService.getPlayerById(playerId)

        if((player!!.wallet - score) < 0) {
            return null
        } else {
            val character = Character("$name${UUID.randomUUID()}", name, score)

            if(player!!.characters != null) {
                player.characters!!.add(character)
            } else {
                player!!.characters = ArrayList<Character>()
                player.characters!!.add(character)
            }

            player.wallet = player.wallet - score

            playerService.updatePlayer(player)
        }

        return player
    }

    fun updateCharacterScore(characterId: String, score: Int, playerId: String): Player? {
        val player = playerService.getPlayerById(playerId)

        player!!.characters!!.forEach {
            if(it.characterId == characterId) {
                if(score > it.score) {
                    val finalSub = score-it.score

                    if((player.wallet - finalSub) < 0) {
                        return null
                    } else {
                        it.score = score
                        player.wallet = player.wallet - finalSub

                        playerService.updatePlayer(player)
                    }
                }
                if(score < it.score) {
                    val finalAdd = it.score-score

                    it.score = score
                    player.wallet = player.wallet + finalAdd

                    playerService.updatePlayer(player)
                }
            }
        }

        return player
    }

    fun deleteCharacter(characterId: String, playerId: String): Player {
        val player = playerService.getPlayerById(playerId)

        var character: Character? = null

        player!!.characters!!.forEach {
            if(it.characterId == characterId) {
                character = it
            }
        }

        if(character != null) {
            player.wallet = player.wallet + character!!.score
            player.characters!!.remove(character!!)

            playerService.updatePlayer(player)
        }

        return player
    }

    fun getAllCharacters(playerId: String): ArrayList<Character> {
        val player = playerService.getPlayerById(playerId)
        return player!!.characters!!
    }
}