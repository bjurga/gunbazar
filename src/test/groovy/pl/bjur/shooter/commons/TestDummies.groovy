package pl.bjur.shooter.commons

import java.time.LocalDateTime

public final class TestDummies {

    static def EMAIL = "email" + random() + "@somedomain.com"
    static def NOT_EXISTING_ID = 123498 + random()

    static LocalDateTime DATE_TIME_IN_PAST = randomDateTime().minusYears(1)
    static LocalDateTime DATE_TIME_IN_FUTURE = randomDateTime().plusYears(getRandomNumberBetween(1, 5))

    static def random() {
        System.nanoTime() + Math.round(Math.random() * 10000)
    }

    static int getRandomNumberBetween(int min, int max) {
        new Random().nextInt(max - min + 1) + min
    }

    static LocalDateTime randomDateTime() {
        LocalDateTime.now()
                .withDayOfYear(getRandomNumberBetween(1, 360))
                .withHour(getRandomNumberBetween(0, 23))
    }

    static String getRandomName() {
        "name" + random()
    }

    static String getRandomEmail() {
        "email" + random() + "@somedomain.com"
    }


}