package errorhandler.dto;

import errorhandler.enums.ErrorCodes;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ErrorDTO {
    private LocalDate timestamp;
    private String code;
    private String description;
    private String message;

    public ErrorDTO(ErrorCodes errorCodes, Exception exception) {
        this.timestamp = LocalDate.now();
        this.code = errorCodes.getCode();
        this.description = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
    }
}
