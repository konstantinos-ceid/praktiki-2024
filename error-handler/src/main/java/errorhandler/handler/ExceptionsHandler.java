package errorhandler.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import errorhandler.errors.EntityNotFoundException;
import errorhandler.errors.IDExistsException;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice   //applied to all controller classes in the Spring application
public class ExceptionsHandler {
    /**
     * Handles exceptions that occur within the application.
     *
     * @param ex The exception that occurred.
     * @return A ResponseEntity containing a message indicating that an error occurred, along with an HTTP status code of INTERNAL_SERVER_ERROR (500).
     */
    @ExceptionHandler(Exception.class)  // handles exceptions of type Exception
    public ResponseEntity<Object> handleException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "An error occurred");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IDExistsException.class)
    public ResponseEntity<Object> handleIDAlreadyExistsException(IDExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
