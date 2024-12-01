package vendingmachine.exception;

public class AmountNumberFormatException extends IllegalArgumentException {

    public AmountNumberFormatException() {
        super(ExceptionMessage.AMOUNT_NUMBER_FORMAT.getMessage());
    }
}
