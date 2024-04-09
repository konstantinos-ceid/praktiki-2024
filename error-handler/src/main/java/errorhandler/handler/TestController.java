package errorhandler.handler;

import errorhandler.enums.ErrorCodes;
import errorhandler.dto.ErrorDTO;
import errorhandler.errors.IDExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    //test for EntityNotFoundException
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
            HttpStatus httpStatus = HttpStatus.valueOf(errorCode.getStatus().getCode());
            return ResponseEntity.status(httpStatus).body(errorDTO);
        }
    }

    //test for IDExistsException
   /* @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        // Simulate checking if the user ID already exists
        boolean userExists = checkIfUserExists(id);
        if (userExists) {
            // If the user ID already exists, return a message indicating that the user already exists
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with ID " + id + " already exists");
        } else {
            // If the user ID doesn't exist, return a message indicating that the user doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + " does not exist");
        }
    }

    private boolean checkIfUserExists(Long id) {
        return id == 1L; // Assuming user with ID 1 exists
    }*/

}

