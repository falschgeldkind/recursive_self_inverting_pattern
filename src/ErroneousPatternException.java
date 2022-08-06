public class ErroneousPatternException extends Throwable {
    public ErroneousPatternException(String message) {
        super(message);
    }
    public ErroneousPatternException(char c) {
        this(c + " is not a valid character! Must be 0 or 1!");
    }
}
