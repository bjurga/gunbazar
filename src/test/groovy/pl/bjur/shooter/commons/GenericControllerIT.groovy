package pl.bjur.shooter.commons

import org.springframework.beans.factory.annotation.Autowired
import pl.bjur.shooter.commons.exceptions.ERROR_CODE
import spock.lang.Ignore

import static pl.bjur.shooter.commons.AssertionUtil.assertErrorCode
import static pl.bjur.shooter.commons.TestDummies.NOT_EXISTING_ID

@Ignore
class GenericControllerIT<E extends IdEntity, D extends IdDto, H extends GenericHelper> extends BaseControllerIT {

    @Autowired
    protected H helper

    def setupSpec() {

    }

    def "Should return all"() {
        given:
        helper.saveEntity()
        def previousCount = getForDtos().size()
        helper.saveEntity()

        when:
        def response = getForDtos()

        then:
        response.size() == previousCount + 1
    }

    def "Should create one"() {
        given:
        D dto = helper.getNewDto()

        when:
        def response = postForDto(dto)

        then:
        helper.assertEqualDto(response, dto)
    }

    def "Should return one"() {
        given:
        E entity = helper.saveEntity()

        when:
        def response = getForDto(entity.id)

        then:
        helper.assertEqualDto(response, entity)   // asertujemy/porownujemy tutaj DTO z Entitym - WTF?
        //// https://github.com/bjurga/gunbazar/issues/7
    }

    def "Should edit one"() {
        given:
        E entity = helper.saveEntity()
        D editedAddressDto = helper.getNewDto()
        editedAddressDto.setId(entity.id)  //REVIEW: testy sie wyjebuja jesli tego ID tu niema. Jest obowiazkowe skoro podajemy model.id ?

        when:
        def response = putForDto(entity.id, editedAddressDto)

        then:
        helper.assertEqualDto(response, editedAddressDto)
    }

    def "Should delete one"() {
        given:
        def previousCount = getForDtos().size()
        E entity = helper.saveEntity()

        when:
        def deleteResponse = deleteOne(entity.id)

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
}

