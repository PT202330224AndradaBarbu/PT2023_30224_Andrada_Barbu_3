package bll.validator;

import java.util.regex.Pattern;
import model.Client;
/**
 * Validator implementation for validating the name of a client.
 */
public class ValidareNume implements Validator<Client> {

    private static final String NUME_PATTERN="[a-zA-Z]+";
    /**
     * Validates the name of a client.
     *
     * @param c the client object to validate
     * @throws IllegalArgumentException if the name does not match the required pattern
     */
    public void validate(Client c) {
        Pattern pattern = Pattern.compile(NUME_PATTERN);
        if (!pattern.matcher(c.getNume()).matches()) {
            throw new IllegalArgumentException("Numele trebuie sa contina doar litere!");
        }
    }

}