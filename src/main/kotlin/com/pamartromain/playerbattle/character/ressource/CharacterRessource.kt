package com.pamartromain.playerbattle.character.ressource

import com.pamartromain.playerbattle.character.entity.Character
import com.pamartromain.playerbattle.character.service.CharacterService
import com.pamartromain.playerbattle.player.entity.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("character")
class CharacterRessource {

    @Autowired
    private lateinit var characterService: CharacterService

    @PostMapping("/{name}/{score}/{playerId}")
    fun addCharacter(@PathVariable(value = "name") name: String, @PathVariable(value = "score") score: Int, @PathVariable(value = "playerId") playerId: String): ResponseEntity<Player> {
        val player = characterService.addCharacter(name, score, playerId)
        return if(player != null) {
            ResponseEntity(player, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{characterId}/{score}/{playerId}")
    fun updateCharacterScore(@PathVariable(value = "characterId") characterId: String, @PathVariable(value = "score") score: Int, @PathVariable(value = "playerId") playerId: String): ResponseEntity<Player> {
        val player = characterService.updateCharacterScore(characterId, score, playerId)
        return if(player != null) {
            ResponseEntity(player, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{characterId}/{playerId}")
    fun deleteCharacter(@PathVariable(value = "characterId") characterId: String, @PathVariable(value = "playerId") playerId: String) = characterService.deleteCharacter(characterId, playerId)

    @GetMapping("/{playerId}")
    fun getAllCharacters(@PathVariable(value = "playerId") playerId: String) = characterService.getAllCharacters(playerId)
}