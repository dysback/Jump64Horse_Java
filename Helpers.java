import static java.lang.System.*;

public class Helpers {

    public static final int MOVES = 64;
    public static final int LOG_LEVEL = 4;
    
    public void logStr(String value, int severity) {
        if(severity >= LOG_LEVEL) {
            out.println("-" + value + "------");
        }
    
    }
    
    public void logInt(int value, int severity) {
        if(severity >= LOG_LEVEL) {
            out.println( "-" + Integer.toString(value) + "------");
        }
    }
}
