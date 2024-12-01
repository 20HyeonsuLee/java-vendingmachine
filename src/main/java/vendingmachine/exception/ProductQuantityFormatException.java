package vendingmachine.exception;

public class ProductQuantityFormatException extends IllegalArgumentBaseException {

    public ProductQuantityFormatException() {
        super(ExceptionMessage.PRODUCT_QUANTITY_FORMAT);
    }
}
