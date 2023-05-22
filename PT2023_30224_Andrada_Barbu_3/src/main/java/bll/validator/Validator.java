package bll.validator;
/**
 * Interface for validating objects of type T.
 *
 * @param <T> The type of object to validate.
 */
public interface Validator<T> {
    /**
     * Validates the specified object.
     *
     * @param t The object to validate.
     */
    public void validate(T t);
}
