package pl.bjur.shooter.commons.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Couldn't find entity with id = " + id);
    }
}
