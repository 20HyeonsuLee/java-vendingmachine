package vendingmachine.exception;

public class AmountNumberFormatException extends IllegalArgumentException {

    protected AmountNumberFormatException(ExceptionMessage exceptionMessage) {
        super(ExceptionMessage.AMOUNT_NUMBER_FORMAT.getMessage());
    }
}
