package errorhandler.errors;

public class IDExistsException extends RuntimeException {
    public IDExistsException(String message) {
        super(message);
    }
}
