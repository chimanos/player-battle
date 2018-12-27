package com.pamartromain.playerbattle.character.service

import com.pamartromain.playerbattle.character.entity.Character
import com.pamartromain.playerbattle.player.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class CharacterService {

    @Autowired
    private lateinit var playerService: PlayerService

    fun addCharacter(name: String, score: Int, playerId: String): ArrayList<Character> {
        val player = playerService.getPlayerById(playerId)
        val character = Character("$name${UUID.randomUUID()}", name, score)

        if(player!!.characters != null) {
            player.characters!!.add(character)
        } else {
            player!!.characters = ArrayList<Character>()
            player.characters!!.add(character)
        }

        return player.characters!!
    }

    fun updateCharacterScore(characterId: String, score: Int, playerId: String): ArrayList<Character> {
        val player = playerService.getPlayerById(playerId)

        player!!.characters!!.forEach {
            if(it.characterId == characterId) {
                it.score = score
            }
        }

        return player.characters!!
    }

    fun deleteCharacter(character: Character, playerId: String): ArrayList<Character> {
        val player = playerService.getPlayerById(playerId)

        player!!.characters!!.remove(character)

        return player.characters!!
    }

    fun getAllCharacters(playerId: String): ArrayList<Character> {
        val player = playerService.getPlayerById(playerId)
        return player!!.characters!!
    }
}