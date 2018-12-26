package com.pamartromain.playerbattle.player.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService {

    @Autowired
    private lateinit var playerService: PlayerService
}