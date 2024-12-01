package vendingmachine.exception;

public class ProductPriceFromatException extends IllegalArgumentException {

    protected ProductPriceFromatException() {
        super(ExceptionMessage.PRODUCT_PRICE_FORMAT.getMessage());
    }
}
