package pl.bjur.shooter.shootingrange

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.bjur.shooter.address.AddressHelper
import pl.bjur.shooter.commons.GenericHelper

import static pl.bjur.shooter.commons.TestDummies.random

@Component
class ShootingRangeHelper implements GenericHelper {

    @Autowired
    private ShootingRangeRepository shootingRangeRepository

    @Autowired
    private AddressHelper addressHelper

    static def NAME = "name" + random()

    @Override
    def saveEntity() {
        ShootingRange entity = getNewEntity()
        addressHelper.saveEntity(entity.address)
        shootingRangeRepository.save(entity)
    }

    @Override
    def getNewEntity() {
        ShootingRange.builder().name(NAME).address(addressHelper.getRandomAddress()).build()
    }

    @Override
    def getNewDto() {
        ShootingRangeDto.builder().name(NAME).address(addressHelper.getRandomAddressDto()).build()
    }

    @Override
    void assertEqualDto(Object response, Object dto) {
        assert response.name == dto.name
    }
}