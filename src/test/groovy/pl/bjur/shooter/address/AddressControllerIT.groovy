package pl.bjur.shooter.address

import org.springframework.beans.factory.annotation.Autowired
import pl.bjur.shooter.BaseControllerIT
import pl.bjur.shooter.BaseModels
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static pl.bjur.shooter.AssertionUtil.assertEqualAddress
import static pl.bjur.shooter.AssertionUtil.assertErrorCode
import static pl.bjur.shooter.BaseModels.*

class AddressControllerIT extends BaseControllerIT {

    @Autowired
    private BaseModels baseModels

    def setupSpec() {
        endpointUrl = '/api/address'
    }

    def "Should return all"() {
        given:
        baseModels.saveAddress()
        def previousCount = getForDtos().size()
        baseModels.saveAddress()

        when:
        def response = getForDtos()

        then:
        response.size() == previousCount + 1
    }

    def "Should create one"() {
        given:
        def addressDto = baseModels.newAddressDto()

        when:
        def response = postForDto(addressDto)

        then:
        assertEqualAddress(response, addressDto)
    }

    def "Should return one"() {
        given:
        def addressDto = baseModels.saveAddress()

        when:
        def response = getForDto(addressDto.id)

        then:
        assertEqualAddress(response, addressDto)

    }

    def "Should edit one"() {
        given:
        def address = baseModels.saveAddress()
        def editedAddressDto = AddressDto.builder()
                .id(address.id)
                .name(NAME + random())
                .city(CITY + random())
                .street(STREET + random())
                .zipCode(ZIP_CODE + random())
                .phoneNumber(PHONE_NUMBER + random()).build()

        when:
        def response = putForDto(address.id, editedAddressDto)

        then:
        assertEqualAddress(response, editedAddressDto)
    }

    def "Should delete one"() {
        given:
        def previousCount = getForDtos().size()
        def address = baseModels.saveAddress()

        when:
        def deleteResponse = deleteOne(address.id)

        and:
        def response = getForDtos()

        then:
        response.size() == previousCount
        deleteResponse.status == 200
    }

    def "Should get 404 when getting not existing one"() {
        when:
        def response = getForResponse(NOT_EXISTING_ID)

        then:
        response.status == 404
        assertErrorCode(response, ERROR_CODE.NOT_FOUND)
    }

    def "Should return 400 on saving empty name"() {
        given:
        def addressDto = baseModels.saveAddress()
        addressDto.name = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty city"() {
        given:
        def addressDto = baseModels.saveAddress()
        addressDto.city = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty street"() {
        given:
        def addressDto = baseModels.saveAddress()
        addressDto.street = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty zipCode"() {
        given:
        def addressDto = baseModels.saveAddress()
        addressDto.zipCode = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }
}
