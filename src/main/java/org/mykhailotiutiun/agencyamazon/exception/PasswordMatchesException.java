package org.mykhailotiutiun.agencyamazon.exception;

public class PasswordMatchesException extends RuntimeException {

    public PasswordMatchesException() {
        super();
    }

    public PasswordMatchesException(String message) {
        super(message);
    }

    public PasswordMatchesException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordMatchesException(Throwable cause) {
        super(cause);
    }
}
