package pl.bjur.shooter.club

import pl.bjur.shooter.commons.GenericControllerIT

class ClubControllerIT extends GenericControllerIT<Club, ClubDto, ClubHelper> {

    def setupSpec() {
        endpointUrl = '/api/club'
    }

    //TODO: Return 400 on missing field
}