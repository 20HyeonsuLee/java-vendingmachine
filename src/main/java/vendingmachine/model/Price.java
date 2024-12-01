package vendingmachine.model;

import vendingmachine.exception.ProductPriceFromatException;

public class Price {
    private final int price;

    public Price(int price) {
        validateAmount(price);
        this.price = price;
    }

    private void validateAmount(int price) {
        if (price < 100 || price % 10 != 0) {
            throw new ProductPriceFromatException();
        }
    }

    public int getPrice() {
        return price;
    }
}
