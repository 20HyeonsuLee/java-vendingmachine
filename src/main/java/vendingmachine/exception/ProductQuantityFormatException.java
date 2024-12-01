package vendingmachine.exception;

public class ProductQuantityFormatException extends IllegalArgumentException {

    protected ProductQuantityFormatException() {
        super(ExceptionMessage.PRODUCT_QUANTITY_FORMAT.getMessage());
    }
}
