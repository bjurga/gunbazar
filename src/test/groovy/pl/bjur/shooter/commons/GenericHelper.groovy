package pl.bjur.shooter.commons

interface GenericHelper {

    BaseRepository repository

    def saveEntity()

    def getNewEntity()

    def getNewDto()

    void assertEqualDto(def response, def dto)
}

