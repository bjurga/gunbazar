package pl.bjur.shooter.tournament.competition

import pl.bjur.shooter.commons.GenericControllerIT
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static pl.bjur.shooter.commons.AssertionUtil.assertErrorCode

class CompetitionControllerIT extends GenericControllerIT<Competition, CompetitionDto, CompetitionHelper> {

    def setupSpec() {
        endpointUrl = '/api/competition'
    }

    def "Should return 400 on saving empty displayName"() {
        given:
        def entity = helper.saveEntity()   //FIXME:
        entity.name = null

        when:
        def response = postForResponse(entity)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty password"() {
        given:
        def entity = helper.saveEntity()   //FIXME:
        entity.description = null

        when:
        def response = postForResponse(entity)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }
}