import groovy.pl.bjur.shooter.club.ClubHelper
import org.springframework.beans.factory.annotation.Autowired
import pl.bjur.shooter.BaseControllerIT

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