package pl.bjur.shooter.commons;

import pl.bjur.shooter.commons.exceptions.NotFoundException;

public final class ValidationUtils {

    public static void validateEntityId(Long id, IdDto dto) {
        if (!id.equals(dto.getId()))
            throw new NotFoundException(id); //FIXME: this is not correct exception.
    }
}
