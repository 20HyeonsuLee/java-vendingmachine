package vendingmachine.exception;

public class ProductPriceFromatException extends IllegalArgumentException {

    public ProductPriceFromatException() {
        super(ExceptionMessage.PRODUCT_PRICE_FORMAT.getMessage());
    }
}
