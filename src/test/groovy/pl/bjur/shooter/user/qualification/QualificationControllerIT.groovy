package pl.bjur.shooter.user.qualification

import pl.bjur.shooter.commons.GenericControllerIT
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static pl.bjur.shooter.commons.AssertionUtil.assertErrorCode

class QualificationControllerIT extends GenericControllerIT<Qualification, QualificationDto, QualificationHelper> {

    def setupSpec() {
        endpointUrl = '/api/qualification'
    }

    def "Should return 400 on saving empty name"() {
        given:
        def entity = helper.saveEntity()   //FIXME:
        entity.name = null

        when:
        def response = postForResponse(entity)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

}