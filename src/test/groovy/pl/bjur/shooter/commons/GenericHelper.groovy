package pl.bjur.shooter.commons

interface GenericHelper {

    BaseRepository repository

    def saveObject()

    def newObject()

    def newObjectDto()

    void assertEqualObject(def o1, def o2)
}

