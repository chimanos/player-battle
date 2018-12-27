package com.pamartromain.playerbattle.character.ressource

import com.pamartromain.playerbattle.character.entity.Character
import com.pamartromain.playerbattle.character.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(" character")
class CharacterRessource {

    @Autowired
    private lateinit var characterService: CharacterService

    @PostMapping("/{name}/{score}/{playerId}")
    fun addCharacter(@PathVariable(value = "name") name: String, @PathVariable(value = "score") score: Int, @PathVariable(value = "playerId") playerId: String)
            = characterService.addCharacter(name, score, playerId)

    @PutMapping("/{characterId}/{score}/{playerId}")
    fun updateCharacterScore(@PathVariable(value = "characterId") characterId: String, @PathVariable(value = "score") score: Int, @PathVariable(value = "playerId") playerId: String)
            = characterService.updateCharacterScore(characterId, score, playerId)

    @DeleteMapping
    fun deleteCharacter(@RequestBody character: Character, playerId: String) = characterService.deleteCharacter(character, playerId)

    @GetMapping("/{playerId}")
    fun getAllCharacters(@PathVariable(value = "playerId") playerId: String) = characterService.getAllCharacters(playerId)
}