package vendingmachine.exception;

public class ProductNameNotBlankException extends IllegalArgumentException {

    protected ProductNameNotBlankException() {
        super(ExceptionMessage.PRODUCT_NAME_NOT_BLANK.getMessage());
    }
}
