package vendingmachine.exception;

public class ProductQuantityFormatException extends IllegalArgumentException {

    protected ProductQuantityFormatException(ExceptionMessage exceptionMessage) {
        super(ExceptionMessage.PRODUCT_QUANTITY_FORMAT.getMessage());
    }
}