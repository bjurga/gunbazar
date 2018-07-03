package pl.bjur.shooter

import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.springframework.mock.web.MockHttpServletResponse
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static pl.bjur.shooter.BaseControllerIT.fromJson

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AssertionUtil {

    static void assertErrorCode(MockHttpServletResponse response, ERROR_CODE error_code) {
        assert fromJson(response.contentAsString).code == error_code.name()
    }

    static void assertEqualAddress(def response, def dto) {
        assert response.name == dto.name
        assert response.street == dto.street
        assert response.zipCode == dto.zipCode
        assert response.city == dto.city
        assert response.phoneNumber == dto.phoneNumber
    }
}
