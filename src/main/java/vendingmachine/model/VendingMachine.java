package vendingmachine.model;

import vendingmachine.exception.AmountNotEnoughException;
import vendingmachine.exception.ProductNameNotFoundException;
import vendingmachine.exception.ProductQuantityNotEnoughException;

public class VendingMachine {
    private final Change change;
    private final Products products;
    private final Amount amount;

    public VendingMachine(Change change, Products products, Amount amount) {
        this.change = change;
        this.products = products;
        this.amount = amount;
    }

    public Change getChange() {
        if (change.getTotalChange() <= amount.getAmount()) {
            return change;
        }
        return new Change(new MachineAmount(amount.getAmount()));
    }

    public boolean isBuyableAnyProduct() {
        return products.buyableProductCount(getAmount()) > 0;
    }

    public void buy(Order order) {
        Product product = validateOrder(order);
        amount.decrease(product.getPrice());
        product.decreaseQuantity();
    }

    private Product validateOrder(Order order) {
        Product product = products.find(order.name()).orElseThrow(ProductNameNotFoundException::new);
        if (!product.isBuyable(amount)) {
            throw new AmountNotEnoughException();
        }
        if (!product.isEnoughQuantity()) {
            throw new ProductQuantityNotEnoughException();
        }
        return product;
    }

    public int getAmount() {
        return amount.getAmount();
    }
}
