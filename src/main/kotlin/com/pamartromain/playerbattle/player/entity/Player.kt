package com.pamartromain.playerbattle.player.entity

import com.pamartromain.playerbattle.character.entity.Character
import com.pamartromain.playerbattle.league.entity.League
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Player(@Id val playerId: String, val login: String, val password: String, var wallet: Int, var leagueId: String?, var characters: ArrayList<Character>?)