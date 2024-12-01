package vendingmachine.exception;

public class QuantityNumberFormatException extends IllegalArgumentBaseException {

    public QuantityNumberFormatException() {
        super(ExceptionMessage.QUANTITY_NUMBER_FORMAT);
    }
}
