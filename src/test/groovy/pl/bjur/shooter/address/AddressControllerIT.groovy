package pl.bjur.shooter.address

import pl.bjur.shooter.BaseControllerIT
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

class AddressControllerIT extends BaseControllerIT {

    def setupSpec() {
        endpointUrl = '/api/address'
    }

    def "Should return all"() {
        given:
        saveAddress()
        def previousCount = getForDtos().size()
        saveAddress()

        when:
        def response = getForDtos()

        then:
        response.size() == previousCount + 1
    }

    def "Should create one"() {
        given:
        def addressDto = newAddressDto()

        when:
        def response = postForDto(addressDto)

        then:
        assertEqualAddress(response, addressDto)
    }

    def "Should return one"() {
        given:
        def addressDto = saveAddress()

        when:
        def response = getForDto(addressDto.id)

        then:
        assertEqualAddress(response, addressDto)

    }

    def "Should edit one"() {
        given:
        def address = saveAddress()
        def editedAddressDto = AddressDto.builder()
                .id(address.id)
                .name(NAME + random())
                .city(NAME + random())
                .street(NAME + random())
                .zipCode(NAME + random())
                .city(NAME + random())
                .phoneNumber(NAME + random()).build()

        when:
        def response = putForDto(address.id, editedAddressDto)

        then:
        assertEqualAddress(response, editedAddressDto)
    }

    def "Should delete one"() {
        given:
        def previousCount = getForDtos().size()
        def address = saveAddress()

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
        def addressDto = saveAddress()
        addressDto.name = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty city"() {
        given:
        def addressDto = saveAddress()
        addressDto.city = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty street"() {
        given:
        def addressDto = saveAddress()
        addressDto.street = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    def "Should return 400 on saving empty zipCode"() {
        given:
        def addressDto = saveAddress()
        addressDto.zipCode = null

        when:
        def response = postForResponse(addressDto)

        then:
        response.status == 400
        assertErrorCode(response, ERROR_CODE.NOT_VALID_PARAM)
    }

    void assertEqualAddress(def response, def dto) {
        assert response.name == dto.name
        assert response.street == dto.street
        assert response.zipCode == dto.zipCode
        assert response.city == dto.city
        assert response.phoneNumber == dto.phoneNumber
    }
}
