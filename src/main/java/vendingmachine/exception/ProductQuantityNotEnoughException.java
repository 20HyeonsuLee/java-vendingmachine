package vendingmachine.exception;

public class ProductQuantityNotEnoughException extends IllegalArgumentBaseException {

    public ProductQuantityNotEnoughException() {
        super(ExceptionMessage.PRODUCT_QUANTITY_NOT_ENOUGH);
    }
}
