package vendingmachine.model;

import vendingmachine.exception.AmountFormatException;

public class Amount {
    private int value;

    public Amount(int amount) {
        validateAmount(amount);
        this.value = amount;
    }

    private void validateAmount(int amount) {
        if (amount % 10 != 0) {
            throw new AmountFormatException();
        }
    }

    public int getValue() {
        return value;
    }

    public void decrease(int amount) {
        if (this.value - amount < 0) {
            throw new AmountFormatException();
        }
        this.value -= amount;
    }
}
