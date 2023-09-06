package res.exceptions;

public class IndexCouloirOutOfBounds extends NoStackTraceRuntimeException {

    public IndexCouloirOutOfBounds() {
        super("L'index fourni ne correspond pas aux couloirs disposés");
    }
}
