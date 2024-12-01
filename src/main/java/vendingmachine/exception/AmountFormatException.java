package vendingmachine.exception;

public class AmountFormatException extends IllegalArgumentException {

    public AmountFormatException() {
        super(ExceptionMessage.AMOUNT_FORMAT.getMessage());
    }
}
