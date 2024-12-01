package vendingmachine.exception;

public class ProductPriceFromatException extends IllegalArgumentBaseException {

    public ProductPriceFromatException() {
        super(ExceptionMessage.PRODUCT_PRICE_FORMAT);
    }
}
