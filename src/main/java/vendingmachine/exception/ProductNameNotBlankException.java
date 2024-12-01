package vendingmachine.exception;

public class ProductNameNotBlankException extends IllegalArgumentBaseException {

    public ProductNameNotBlankException() {
        super(ExceptionMessage.PRODUCT_NAME_NOT_BLANK);
    }
}
