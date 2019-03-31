package pl.bjur.shooter.address

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.bjur.shooter.commons.GenericHelper

import static pl.bjur.shooter.commons.TestDummies.getRandomName
import static pl.bjur.shooter.commons.TestDummies.random

@Component
class AddressHelper implements GenericHelper {

    @Autowired
    private AddressRepository addressRepository

    static def NAME = "name" + random()
    static def CITY = "city" + random()
    static def STREET = "street" + random()
    static def ZIP_CODE = "zipCode" + random()
    static def PHONE = "+48 (32)" + random()

    @Override
    def saveEntity() {
        addressRepository.save(getNewEntity())
    }

    def saveEntity(Address address) {
        addressRepository.save(address)
    }

    @Override
    def getNewEntity() {
        Address.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build()
    }

    @Override
    def getNewDto() {
        AddressDto.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phone(PHONE).build()
    }

    @Override
    void assertEqualDto(def response, def dto) {
        assert response.name == dto.name
        assert response.street == dto.street
        assert response.zipCode == dto.zipCode
        assert response.city == dto.city
        assert response.phone == dto.phone
    }

    static Address getRandomAddress() {
        Address.builder().name(getRandomName()).city("city" + random()).street("street" + random())
                .zipCode("zipCode" + random()).phone("+48 (32)" + random()).build()
    }

    static AddressDto getRandomAddressDto() {
        AddressDto.builder().name(getRandomName()).city("city" + random()).street("street" + random())
                .zipCode("zipCode" + random()).phone("+48 (32)" + random()).build()
    }
}
