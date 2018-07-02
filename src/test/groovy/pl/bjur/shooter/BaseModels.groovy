package pl.bjur.shooter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.bjur.shooter.address.Address
import pl.bjur.shooter.address.AddressDto
import pl.bjur.shooter.address.AddressRepository


@Component
class BaseModels {

    @Autowired
    private AddressRepository repository

    static def NOT_EXISTING_ID = 123498 + random()
    static def NAME = "name" + random()
    static def CITY = "city" + random()
    static def STREET = "street" + random()
    static def ZIP_CODE = "zipCode" + random()
    static def PHONE_NUMBER = "phoneNumber" + random()

    static def random() {
        System.nanoTime() + Math.round(Math.random() * 10000)
    }

    def saveAddress() {
        repository.save(Address.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phoneNumber(PHONE_NUMBER).build())
    }

    def newAddressDto() {
        AddressDto.builder().name(NAME).city(CITY).street(STREET).zipCode(ZIP_CODE).phoneNumber(PHONE_NUMBER).build()
    }
}
