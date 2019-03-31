package pl.bjur.shooter.commons

import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.springframework.mock.web.MockHttpServletResponse
import pl.bjur.shooter.commons.exceptions.ERROR_CODE

import java.time.LocalDateTime

import static BaseControllerIT.fromJson

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AssertionUtil {

    static void assertErrorCode(MockHttpServletResponse response, ERROR_CODE error_code) {
        assert fromJson(response.contentAsString).code == error_code.name()
    }

    static void assertDatesEquals(LocalDateTime d1, LocalDateTime d2) {
        assert d1.equals(d2)
    }


}
