package com.pamartromain.playerbattle.league.service

import com.pamartromain.playerbattle.league.dao.LeagueDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LeagueService {

    @Autowired
    private lateinit var leagueDAO: LeagueDAO
}