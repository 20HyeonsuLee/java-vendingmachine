package vendingmachine.exception;

public class ProductFormatException extends IllegalArgumentException {

    public ProductFormatException() {
        super(ExceptionMessage.PRODUCT_FORMAT.getMessage());
    }
}
