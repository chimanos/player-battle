package com.pamartromain.playerbattle.character.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Character(@Id val characterId: String, val name: String, var score: Int)