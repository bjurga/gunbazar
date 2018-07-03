package pl.bjur.shooter.club

import org.springframework.beans.factory.annotation.Autowired
import pl.bjur.shooter.commons.BaseControllerIT

class ClubControllerIT extends BaseControllerIT {

    @Autowired
    private ClubHelper clubHelper

    def setupSpec() {
        endpointUrl = '/api/club'
    }

    def "Should return all"() {
        given:
        clubHelper.saveAddress()
        def previousCount = getForDtos().size()
        clubHelper.saveAddress()

        when:
        def response = getForDtos()

        then:
        response.size() == previousCount + 1
    }
}