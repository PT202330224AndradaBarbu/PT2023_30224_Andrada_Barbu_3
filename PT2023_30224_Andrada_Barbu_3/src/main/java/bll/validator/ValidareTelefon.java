package bll.validator;

import model.Client;

import java.util.regex.Pattern;
/**
 * Validator implementation for validating the phone number of a client.
 */
public class ValidareTelefon implements Validator<Client> {

    private static final String TELEFON_PATTERN = "^\\d{10}$";
    /**
     * Validates the phone number of a client.
     *
     * @param c the client object to validate
     * @throws IllegalArgumentException if the phone number does not match the required pattern
     */
    public void validate(Client c) {
        String nrTel= c.getTelefon();
        Pattern pattern = Pattern.compile(TELEFON_PATTERN);
        if(!pattern.matcher(nrTel).matches()) {
            throw new IllegalArgumentException("Numarul de telefon introdus nu este valid!");
        }
    }
}
