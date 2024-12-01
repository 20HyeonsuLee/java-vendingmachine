package vendingmachine.exception;

public class AmountNotEnoughException extends IllegalArgumentException {

    public AmountNotEnoughException() {
        super(ExceptionMessage.AMOUNT_NOT_ENOUGH.getMessage());
    }
}
