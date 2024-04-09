package errorhandler.handler;

import errorhandler.enums.ErrorCodes;
import errorhandler.dto.ErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        // Simulate retrieving a user by ID
        if (id == 1L) {
            // Return a mock user object
            String userName = "John Doe";
            return ResponseEntity.ok(userName);
        } else {
            // Return an error response if the user ID doesn't exist
            ErrorCodes errorCode = new ErrorCodes();
            EntityNotFoundException exception = new EntityNotFoundException("User not found with id " + id);
            ErrorDTO errorDTO = new ErrorDTO(errorCode, exception);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
        }
    }

}

