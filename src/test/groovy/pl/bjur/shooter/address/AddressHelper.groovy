package pl.bjur.shooter.address

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.bjur.shooter.commons.GenericHelper

import static pl.bjur.shooter.commons.TestDummies.random

@Component
class AddressHelper implements GenericHelper {

    @Autowired
    private AddressRepository addressRepository

    static def NAME = "name" + random()
    static def CITY = "city" + random()
    static def STREET = "street" + random()
    static def ZIP_CODE = "zipCode" + random()
    static def PHONE = "phone" + random()

    @Override
    def saveObject() {
        addressRepository.save(newObject())
    }

    @Override
    def newObject() {
        Address.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build()
    }

    @Override
    def newObjectDto() {
        AddressDto.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build()
    }

    @Override
    void assertEqualObject(def response, def dto) {
        assert response.name == dto.name
        assert response.street == dto.street
        assert response.zipCode == dto.zipCode
        assert response.city == dto.city
        assert response.phone == dto.phone
    }

// backup:
//    def saveAddress() {
//        addressRepository.save(newAddress())
//    }
//
//    static def newAddress() {
//        Address.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build()
//    }
//
//    static def newAddressDto() {
//        AddressDto.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build()
//    }

//    static void assertEqualAddress(def response, def dto) {
//        assert response.name == dto.name
//        assert response.street == dto.street
//        assert response.zipCode == dto.zipCode
//        assert response.city == dto.city
//        assert response.phone == dto.phone
//    }
}
