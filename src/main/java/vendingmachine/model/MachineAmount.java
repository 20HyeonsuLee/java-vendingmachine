package vendingmachine.model;

import vendingmachine.exception.AmountFormatException;

public class MachineAmount {
    private int amount;

    public MachineAmount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < 0 || amount % 10 != 0) {
            throw new AmountFormatException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
