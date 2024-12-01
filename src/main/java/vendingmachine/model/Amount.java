package vendingmachine.model;

import vendingmachine.exception.AmountFormatException;

public class Amount {
    private int amount;

    public Amount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount % 10 != 0) {
            throw new AmountFormatException();
        }
    }

    public int getAmount() {
        return amount;
    }

    public void decrease(int amount) {
        if (this.amount - amount < 0) {
            throw new AmountFormatException();
        }
        this.amount -= amount;
    }
}
