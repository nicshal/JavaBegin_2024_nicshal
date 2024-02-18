package nicshal.homework8;

public class AppArrayDataException extends RuntimeException {

    public AppArrayDataException(String errorMessage) {
        super(errorMessage);
    }

    public AppArrayDataException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}