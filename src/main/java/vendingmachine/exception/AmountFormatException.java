package vendingmachine.exception;

public class AmountFormatException extends IllegalArgumentBaseException {

    public AmountFormatException() {
        super(ExceptionMessage.AMOUNT_FORMAT);
    }
}
