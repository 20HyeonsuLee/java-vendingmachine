package vendingmachine.exception;

public class PriceNumberFormatException extends IllegalArgumentException {

    protected PriceNumberFormatException() {
        super(ExceptionMessage.PRICE_NUMBER_FORMAT.getMessage());
    }
}
