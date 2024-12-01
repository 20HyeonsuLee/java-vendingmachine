package vendingmachine.exception;

public class ProductPriceFromatException extends IllegalArgumentException {

    protected ProductPriceFromatException(ExceptionMessage exceptionMessage) {
        super(ExceptionMessage.PRODUCT_PRICE_FORMAT.getMessage());
    }
}
