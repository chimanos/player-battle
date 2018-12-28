package com.pamartromain.playerbattle.fight.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Fight(@Id val fightId: String, val characterOneNameAndScore: String, val characterTwoNameAndScore: String, val date: String, val winnerName: String)