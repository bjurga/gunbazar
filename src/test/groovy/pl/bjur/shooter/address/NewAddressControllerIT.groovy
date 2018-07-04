package pl.bjur.shooter.address

import pl.bjur.shooter.commons.GenericControllerIT
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static pl.bjur.shooter.commons.AssertionUtil.assertErrorCode

//TODO: rename to AddressControllerIT
class NewAddressControllerIT extends GenericControllerIT<Address, AddressDto, AddressHelper> {

    def setupSpec() {
        endpointUrl = '/api/address'
    }

    def "Should return 400 on saving empty name"() {
        given:
        def addressDto = helper.saveObject()   //FIXME:
        addressDto.name = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty city"() {
        given:
        def addressDto = helper.saveObject()   //FIXME:
        addressDto.city = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty street"() {
        given:
        def addressDto = helper.saveObject()   //FIXME:
        addressDto.street = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty zipCode"() {
        given:
        def addressDto = helper.saveObject()   //FIXME:
        addressDto.zipCode = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }
}