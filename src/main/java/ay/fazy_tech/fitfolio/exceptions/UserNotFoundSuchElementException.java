package ay.fazy_tech.fitfolio.exceptions;

import java.util.NoSuchElementException;

/**
 * @author Anna Zelener
 */
public class UserNotFoundSuchElementException extends NoSuchElementException {
    public UserNotFoundSuchElementException() {
        super();
    }

    public UserNotFoundSuchElementException(String s) {
        super(s);
    }
}
