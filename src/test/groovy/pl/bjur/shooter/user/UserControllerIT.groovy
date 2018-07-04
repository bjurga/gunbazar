package pl.bjur.shooter.user

import pl.bjur.shooter.commons.GenericControllerIT
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static pl.bjur.shooter.commons.AssertionUtil.assertErrorCode

class UserControllerIT extends GenericControllerIT<User, UserDto, UserHelper> {

    def setupSpec() {
        endpointUrl = '/api/user'
    }

    def "Should return 400 on saving empty displayName"() {
        given:
        def entity = helper.saveEntity()   //FIXME:
        entity.displayName = null

        when:
        def response = postForResponse(entity)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty password"() {
        given:
        def entity = helper.saveEntity()   //FIXME:
        entity.password = null

        when:
        def response = postForResponse(entity)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty email"() {
        given:
        def entity = helper.saveEntity()   //FIXME:
        entity.email = null

        when:
        def response = postForResponse(entity)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

}