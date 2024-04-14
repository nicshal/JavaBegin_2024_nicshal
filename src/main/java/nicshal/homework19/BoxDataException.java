package nicshal.homework19;

public class BoxDataException extends RuntimeException {

    public BoxDataException(String errorMessage) {
        super(errorMessage);
    }

    public BoxDataException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}