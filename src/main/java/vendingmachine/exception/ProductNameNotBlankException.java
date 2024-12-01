package vendingmachine.exception;

public class ProductNameNotBlankException extends IllegalArgumentException {

    public ProductNameNotBlankException() {
        super(ExceptionMessage.PRODUCT_NAME_NOT_BLANK.getMessage());
    }
}
