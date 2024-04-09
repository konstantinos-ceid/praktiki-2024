package errorhandler.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorCodes {
    private static Integer counter = 0; // Incremented globally with static
    private String code;
    private StatusCode status;

    public ErrorCodes() {
        this.code = generateCode();
        this.status = StatusCode.STATUS_INTERNAL_SERVER_ERROR; // Default status code
    }

    public ErrorCodes(StatusCode status) {
        this.code = generateCode();
        this.status = status;
    }

    private String generateCode() {
        counter++;
        return "PR-" + String.format("%03d", counter);
    }

    @Getter
    public enum StatusCode {
        STATUS_NOT_FOUND(404),
        STATUS_OK(200),
        STATUS_INTERNAL_SERVER_ERROR(500),
        STATUS_CONFLICT(409);

        private final int code;

        StatusCode(int code) {
            this.code = code;
        }
    }
}
