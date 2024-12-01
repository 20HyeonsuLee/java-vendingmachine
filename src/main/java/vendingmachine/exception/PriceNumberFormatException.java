package vendingmachine.exception;

public class PriceNumberFormatException extends IllegalArgumentException {

    protected PriceNumberFormatException(ExceptionMessage exceptionMessage) {
        super(ExceptionMessage.PRICE_NUMBER_FORMAT.getMessage());
    }
}
