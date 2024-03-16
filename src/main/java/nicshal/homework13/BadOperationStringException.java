package nicshal.homework13;

public class BadOperationStringException extends RuntimeException {

    public BadOperationStringException(String errorMessage) {
        super(errorMessage);
    }

    public BadOperationStringException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}