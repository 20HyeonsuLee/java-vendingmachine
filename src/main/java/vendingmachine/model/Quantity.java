package vendingmachine.model;

import vendingmachine.exception.ProductQuantityFormatException;

public class Quantity {
    private final int quantity;

    public Quantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new ProductQuantityFormatException();
        }
    }
}