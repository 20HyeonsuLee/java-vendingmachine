package vendingmachine.exception;

public class IllegalArgumentBaseException extends IllegalArgumentException {

    protected IllegalArgumentBaseException(ExceptionMessage exceptionMessage) {
        super(String.format("[ERROR] %s", exceptionMessage.getMessage()));
    }
}
