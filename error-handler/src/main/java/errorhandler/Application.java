package errorhandler;

import errorhandler.enums.ErrorCodes;
import errorhandler.dto.ErrorDTO;
import errorhandler.errors.IDExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// Creating an EntityNotFoundException with its own ErrorCodes instance
		ErrorCodes errorCodeEntityNotFound = new ErrorCodes();
		// Creating an EntityNotFoundException
		EntityNotFoundException entityNotFoundException = new EntityNotFoundException("Entity not found");
		ErrorDTO entityNotFoundErrorDTO = new ErrorDTO(errorCodeEntityNotFound, entityNotFoundException);
		// Creating an IDExistsException with its own ErrorCodes instance
		ErrorCodes errorCodeIDExists = new ErrorCodes();
		// Creating an IDExistsException
		IDExistsException idExistsException = new IDExistsException("ID already exists");
		ErrorDTO idExistsErrorDTO = new ErrorDTO(errorCodeIDExists, idExistsException);
		// Printing details of EntityNotFoundException
		printErrorDetails(entityNotFoundErrorDTO);
		// Printing details of IDExistsException
		printErrorDetails(idExistsErrorDTO);
	}

	private static void printErrorDetails(ErrorDTO errorDTO) {
		System.out.println("Timestamp: " + errorDTO.getTimestamp());
		System.out.println("Code: " + errorDTO.getCode());
		System.out.println("Description: " + errorDTO.getDescription());
		System.out.println("Message: " + errorDTO.getMessage());
		System.out.println(); // Add an empty line for separation
	}
}
