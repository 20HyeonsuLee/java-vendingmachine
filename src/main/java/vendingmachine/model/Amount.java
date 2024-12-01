package vendingmachine.model;

import vendingmachine.exception.AmountFormatException;
import vendingmachine.exception.AmountNumberFormatException;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount % 10 != 0) {
            throw new AmountFormatException();
        }
    }
}
