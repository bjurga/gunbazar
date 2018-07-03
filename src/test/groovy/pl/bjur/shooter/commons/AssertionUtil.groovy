package pl.bjur.shooter.commons

import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.springframework.mock.web.MockHttpServletResponse
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import static BaseControllerIT.fromJson

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AssertionUtil {

    static void assertErrorCode(MockHttpServletResponse response, ERROR_CODE error_code) {
        assert fromJson(response.contentAsString).code == error_code.name()
    }


}
