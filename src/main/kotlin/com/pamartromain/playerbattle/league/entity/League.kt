package com.pamartromain.playerbattle.league.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class League(@Id val leagueId: String, val name: String, var nbPlayer: Int)