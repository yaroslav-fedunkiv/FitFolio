package ay.fazy_tech.fitfolio.exceptions;

import java.util.NoSuchElementException;

/**
 * @author Anna Zelener
 */
public class NoSuchUserFoundException extends NoSuchElementException {
    public NoSuchUserFoundException() {
        super();
    }

    public NoSuchUserFoundException(String s) {
        super(s);
    }
}
