package com.pamartromain.playerbattle.character.service

import com.pamartromain.playerbattle.character.dao.CharacterDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CharacterService {

    @Autowired
    private lateinit var characterDAO: CharacterDAO
}