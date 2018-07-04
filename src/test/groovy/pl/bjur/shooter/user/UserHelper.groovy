package pl.bjur.shooter.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.bjur.shooter.commons.GenericHelper
import pl.bjur.shooter.user.qualification.Qualification
import pl.bjur.shooter.user.qualification.QualificationDto
import pl.bjur.shooter.user.qualification.QualificationHelper

import static pl.bjur.shooter.commons.TestDummies.*

@Component
class UserHelper implements GenericHelper {

    @Autowired
    private UserRepository userRepository

    @Autowired
    private QualificationHelper qualificationHelper

    static def PASSWORD = "password" + random()

    @Override
    def saveEntity() {
        userRepository.save(getNewEntity())
    }

    @Override
    def getNewEntity() {
        User.builder().displayName("display_" + getRandomName()).email(getRandomEmail())
                .password(PASSWORD).qualifications(getRandomQualificationSet()).build()
    }

    @Override
    def getNewDto() {
        UserDto.builder().displayName("display_" + getRandomName()).email(getRandomEmail())
                .password(PASSWORD).qualifications(getRandomQualificationDtoSet()).build()
    }

    @Override
    void assertEqualDto(def response, def dto) {
        assert response.displayName == dto.displayName
        assert response.email == dto.email
        assert response.password == dto.password
    }

    private Set<Qualification> getRandomQualificationSet() {
        HashSet<Qualification> result = new HashSet<>()
        result.add(qualificationHelper.getNewEntity())
        result.add(qualificationHelper.getNewEntity())
        result.add(qualificationHelper.getNewEntity())
        return result
    }

    private Set<QualificationDto> getRandomQualificationDtoSet() {
        HashSet<QualificationDto> result = new HashSet<>()
        result.add(qualificationHelper.getNewDto())
        result.add(qualificationHelper.getNewDto())
        result.add(qualificationHelper.getNewDto())
        return result
    }
}
