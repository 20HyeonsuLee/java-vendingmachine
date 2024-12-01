package vendingmachine.model;

import vendingmachine.exception.AmountNotEnoughException;

public class Product {
    private final Name name;
    private final Price price;
    private final Quantity quantity;

    public Product(Name name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Name getName() {
        return name;
    }

    public boolean isBuyable(Amount amount) {
        return price.getPrice() <= amount.getAmount();
    }

    public int getPrice() {
        return price.getPrice();
    }
}
