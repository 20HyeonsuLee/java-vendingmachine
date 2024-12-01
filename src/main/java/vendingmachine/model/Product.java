package vendingmachine.model;

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
        return price.getValue() <= amount.getValue();
    }

    public int getPrice() {
        return price.getValue();
    }

    public void decreaseQuantity() {
        this.quantity.decrease();
    }

    public int getQuantity() {
        return quantity.getQuantity();
    }

    public boolean isEnoughQuantity() {
        return quantity.getQuantity() > 0;
    }
}
