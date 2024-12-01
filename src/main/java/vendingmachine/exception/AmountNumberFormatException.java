package vendingmachine.exception;

public class AmountNumberFormatException extends IllegalArgumentBaseException {

    public AmountNumberFormatException() {
        super(ExceptionMessage.AMOUNT_NUMBER_FORMAT);
    }
}
