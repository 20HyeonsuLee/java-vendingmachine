package vendingmachine.model;

public class Order {
    private final Name productName;

    public Order(Name productName) {
        this.productName = productName;
    }

    public Name name() {
        return new Name(productName.getName());
    }
}
