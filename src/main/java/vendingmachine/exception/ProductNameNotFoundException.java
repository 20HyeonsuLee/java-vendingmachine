package vendingmachine.exception;

public class ProductNameNotFoundException extends IllegalArgumentException {

    public ProductNameNotFoundException() {
        super(ExceptionMessage.PRODUCT_NAME_NOT_FOUND.getMessage());
    }
}
