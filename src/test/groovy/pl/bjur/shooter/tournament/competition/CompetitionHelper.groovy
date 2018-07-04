package pl.bjur.shooter.tournament.competition

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.bjur.shooter.commons.GenericHelper

import static pl.bjur.shooter.commons.TestDummies.random

@Component
class CompetitionHelper implements GenericHelper {

    @Autowired
    private CompetitionRepository competitionRepository

    static def NAME = "name" + random()
    static def DESCRIPTION = "Description " + random() + "text."

    @Override
    def saveEntity() {
        competitionRepository.save(getNewEntity())
    }

    @Override
    def getNewEntity() {
        Competition.builder().name(NAME).description(DESCRIPTION).build()
    }

    @Override
    def getNewDto() {
        CompetitionDto.builder().name(NAME).description(DESCRIPTION).build()
    }

    @Override
    void assertEqualDto(def response, def dto) {
        assert response.name == dto.name
        assert response.description == dto.description
    }
}
