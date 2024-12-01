package vendingmachine.exception;

public class AmountNotEnoughException extends IllegalArgumentBaseException {

    public AmountNotEnoughException() {
        super(ExceptionMessage.AMOUNT_NOT_ENOUGH);
    }
}
