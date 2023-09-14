package res;

import res.exceptions.NoStackTraceRuntimeException;

public class Utils {
    private Utils() {
        throw new NoStackTraceRuntimeException("Cette classe est utilitaire, elle ne peut être instanciée");
    }

    public static void println(Object o) {
        System.out.println(o);
    }
}
