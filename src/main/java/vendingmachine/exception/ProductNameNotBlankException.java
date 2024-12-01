package vendingmachine.exception;

public class ProductNameNotBlankException extends IllegalArgumentException {

    protected ProductNameNotBlankException(ExceptionMessage exceptionMessage) {
        super(ExceptionMessage.PRODUCT_NAME_NOT_BLANK.getMessage());
    }
}
