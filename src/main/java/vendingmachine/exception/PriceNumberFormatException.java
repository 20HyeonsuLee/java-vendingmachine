package vendingmachine.exception;

public class PriceNumberFormatException extends IllegalArgumentBaseException {

    public PriceNumberFormatException() {
        super(ExceptionMessage.PRICE_NUMBER_FORMAT);
    }
}
