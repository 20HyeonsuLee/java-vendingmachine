package vendingmachine.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Products implements Iterable<Product> {
    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public Optional<Product> find(Name name) {
        return products.stream().filter(product -> product.getName().equals(name)).findFirst();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    @Override
    public void forEach(Consumer<? super Product> action) {
        Iterable.super.forEach(action);
    }

    public int findMinPrice() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .min().getAsInt();
    }
}
