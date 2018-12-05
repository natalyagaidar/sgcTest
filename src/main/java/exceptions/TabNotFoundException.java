package exceptions;

public class TabNotFoundException extends RuntimeException {

    public TabNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

