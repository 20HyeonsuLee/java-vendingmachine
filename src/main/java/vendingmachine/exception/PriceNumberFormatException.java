package vendingmachine.exception;

public class PriceNumberFormatException extends IllegalArgumentException {

    public PriceNumberFormatException() {
        super(ExceptionMessage.PRICE_NUMBER_FORMAT.getMessage());
    }
}
