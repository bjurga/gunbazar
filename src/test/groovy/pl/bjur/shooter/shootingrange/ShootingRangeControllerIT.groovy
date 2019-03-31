package pl.bjur.shooter.shootingrange

import pl.bjur.shooter.commons.GenericControllerIT
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static pl.bjur.shooter.commons.AssertionUtil.assertErrorCode

class ShootingRangeControllerIT extends GenericControllerIT<ShootingRange, ShootingRangeDto, ShootingRangeHelper> {

    def setupSpec() {
        endpointUrl = '/api/shootingrange'
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

    def "Should return 400 on saving empty address"() {
        given:
        def entity = helper.saveEntity()   //FIXME:
        entity.address = null

        when:
        def response = postForResponse(entity)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }
}