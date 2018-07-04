package pl.bjur.shooter.user.qualification

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.bjur.shooter.commons.GenericHelper

import java.time.LocalDateTime

import static pl.bjur.shooter.commons.AssertionUtil.assertDatesEquals
import static pl.bjur.shooter.commons.TestDummies.*

@Component
class QualificationHelper implements GenericHelper {

    @Autowired
    private QualificationRepository qualificationRepository

    static def NAME = "name" + random()
    static def QUALIFICATION_NUMBER = "QUA" + random()
    static LocalDateTime VALID_FROM = DATE_TIME_IN_PAST
    static LocalDateTime VALID_TO = DATE_TIME_IN_FUTURE

    @Override
    def saveEntity() {
        qualificationRepository.save(getNewEntity())
    }

    @Override
    def getNewEntity() {
        Qualification.builder().name(NAME).qualificationNumber(QUALIFICATION_NUMBER)
                .validFrom(VALID_FROM).validTo(VALID_TO).build()
    }

    @Override
    def getNewDto() {
        QualificationDto.builder().name(NAME).qualificationNumber(QUALIFICATION_NUMBER)
                .validFrom(VALID_FROM).validTo(VALID_TO).build()
    }

    @Override
    void assertEqualDto(def response, def dto) {
        assert response.name == dto.name
        assert response.qualificationNumber == dto.qualificationNumber
        assertDatesEquals(LocalDateTime.parse(response.validTo), dto.validTo)
        assertDatesEquals(LocalDateTime.parse(response.validFrom), dto.validFrom)
    }
}