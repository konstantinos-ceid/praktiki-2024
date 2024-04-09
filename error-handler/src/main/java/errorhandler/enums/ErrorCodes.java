package errorhandler.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorCodes {
    private static Integer counter = 0; //incremented globally with static
    private String code;
    private Integer status;

    public static int STATUS_NOT_FOUND = 404;
    public static int STATUS_OK = 200;
    public static int STATUS_INTERNAL_SERVER_ERROR = 500;

    public ErrorCodes() {
        this.code = generateCode();
        this.status = STATUS_INTERNAL_SERVER_ERROR; // Default status code
    }

    public ErrorCodes(int status) {
        this.code = generateCode();
        if (status == STATUS_NOT_FOUND || status == STATUS_OK || status == STATUS_INTERNAL_SERVER_ERROR) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status code");
        }
    }

    private String generateCode() {
        counter++;
        return "PR-" + String.format("%03d", counter);
    }
}
