package vendingmachine.exception;

public class AmountNumberFormatException extends IllegalArgumentException {

    protected AmountNumberFormatException() {
        super(ExceptionMessage.AMOUNT_NUMBER_FORMAT.getMessage());
    }
}
