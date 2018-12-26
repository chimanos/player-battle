package com.pamartromain.playerbattle.character.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Character(val name: String, val score: Int)