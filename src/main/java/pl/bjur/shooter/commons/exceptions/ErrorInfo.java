package pl.bjur.shooter.commons.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorInfo {
    private final ERROR_CODE code;
    private final String message;
}
