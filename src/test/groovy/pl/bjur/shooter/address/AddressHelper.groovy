package pl.bjur.shooter.address

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static pl.bjur.shooter.commons.TestDummies.random

@Component
class AddressHelper {

    @Autowired
    private AddressRepository addressRepository

    static def NOT_EXISTING_ID = 123498 + random()
    static def NAME = "name" + random()
    static def CITY = "city" + random()
    static def STREET = "street" + random()
    static def ZIP_CODE = "zipCode" + random()
    static def PHONE = "phone" + random()

    def saveAddress() {
        addressRepository.save(Address.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build())
    }

    def newAddressDto() {
        AddressDto.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build()
    }

    static void assertEqualAddress(def response, def dto) {
        assert response.name == dto.name
        assert response.street == dto.street
        assert response.zipCode == dto.zipCode
        assert response.city == dto.city
        assert response.phone == dto.phone
    }
}
