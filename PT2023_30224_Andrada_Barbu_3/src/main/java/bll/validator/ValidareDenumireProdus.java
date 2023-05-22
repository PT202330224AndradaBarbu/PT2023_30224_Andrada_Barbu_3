package bll.validator;

import bll.ProdusBLL;
import model.Produs;

import java.util.List;
/**
 * Validator implementation for validating the uniqueness of a product's name.
 */

public class ValidareDenumireProdus implements Validator<Produs> {
    /**
     * Validates the uniqueness of the product's name.
     *
     * @param produs The product to validate.
     * @throws IllegalArgumentException if the product's name already exists.
     */
    @Override
    public void validate(Produs produs) {
        ProdusBLL produsBLL = new ProdusBLL();
        List<Produs> produse = produsBLL.cautareProdus();
        for (Produs p : produse) {
            if (p.getDenumire().equals(produs.getDenumire())) {
                throw new IllegalArgumentException("Produsul exista deja!");
            }
        }
    }
}
