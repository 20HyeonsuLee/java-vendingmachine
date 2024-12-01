package vendingmachine.exception;

public class ProductNameNotFoundException extends IllegalArgumentBaseException {

    public ProductNameNotFoundException() {
        super(ExceptionMessage.PRODUCT_NAME_NOT_FOUND);
    }
}
