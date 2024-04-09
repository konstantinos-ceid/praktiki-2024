package errorhandler.handler;

import errorhandler.enums.ErrorCodes;
import errorhandler.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    /**
     * Handles EntityNotFoundException and returns a ResponseEntity with status code NOT_FOUND.
     * @param ex The EntityNotFoundException that occurred.
     * @return A ResponseEntity with status code NOT_FOUND.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorCodes errorCodes = new ErrorCodes(ErrorCodes.StatusCode.STATUS_NOT_FOUND);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(errorCodes.getStatus().getCode()));
    }

    /**
     * Handles IDExistsException and returns a ResponseEntity with status code CONFLICT.
     * @param ex The IDExistsException that occurred.
     * @return A ResponseEntity with status code CONFLICT.
     */
    @ExceptionHandler(IDExistsException.class)
    public ResponseEntity<Object> handleIDAlreadyExistsException(IDExistsException ex) {
        ErrorCodes errorCodes = new ErrorCodes(ErrorCodes.StatusCode.STATUS_CONFLICT);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(errorCodes.getStatus().getCode()));
    }
}
