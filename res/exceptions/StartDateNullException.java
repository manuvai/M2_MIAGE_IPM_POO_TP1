package res.exceptions;

public class StartDateNullException extends NoStackTraceRuntimeException {
    public StartDateNullException() {
        super("Vous ne pouvez pas finir avant de commencer");
    }
}
