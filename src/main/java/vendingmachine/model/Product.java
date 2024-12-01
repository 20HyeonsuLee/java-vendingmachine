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

}
