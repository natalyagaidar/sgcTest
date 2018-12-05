package exceptions;

public class PageNotLoadedException extends RuntimeException {

    public PageNotLoadedException(String errorMessage) {
        super(errorMessage);
    }
}
