package pl.bjur.shooter.club

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static pl.bjur.shooter.commons.TestDummies.random

@Component
class ClubHelper {

    @Autowired
    private ClubRepository clubRepository

    static def CLUB_NAME = "club_name" + random()
    static def PZSS_CLUB_LICENCE = "LIC/" + random() + "/" + random()

}

