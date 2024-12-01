package vendingmachine.exception;

public class ProductQuantityFormatException extends IllegalArgumentException {

    public ProductQuantityFormatException() {
        super(ExceptionMessage.PRODUCT_QUANTITY_FORMAT.getMessage());
    }
}
