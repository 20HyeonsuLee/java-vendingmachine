package vendingmachine.model;

import vendingmachine.exception.ProductPriceFromatException;

public class Price {
    private final int value;

    public Price(int price) {
        validateAmount(price);
        this.value = price;
    }

    private void validateAmount(int price) {
        if (price < 100 || price % 10 != 0) {
            throw new ProductPriceFromatException();
        }
    }

    public int getValue() {
        return value;
    }
}
