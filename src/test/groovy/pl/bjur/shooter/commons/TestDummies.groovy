package pl.bjur.shooter.commons

public final class TestDummies {

    static def NOT_EXISTING_ID = 123498 + random()

    static def random() {
        System.nanoTime() + Math.round(Math.random() * 10000)
    }


}