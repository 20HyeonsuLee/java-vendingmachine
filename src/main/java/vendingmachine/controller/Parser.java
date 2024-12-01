package vendingmachine.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import vendingmachine.exception.AmountNumberFormatException;
import vendingmachine.exception.PriceNumberFormatException;
import vendingmachine.exception.ProductFormatException;
import vendingmachine.exception.QuantityNumberFormatException;
import vendingmachine.model.Amount;
import vendingmachine.model.MachineAmount;
import vendingmachine.model.Name;
import vendingmachine.model.Order;
import vendingmachine.model.Price;
import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.model.Quantity;

public class Parser {

    private Parser() {
    }

    public static MachineAmount parseAmountInt(String amount) {
        try {
            return new MachineAmount(Integer.parseInt(amount));
        }catch (NumberFormatException exception) {
            throw new AmountNumberFormatException();
        }
    }

    public static Amount parseAmount(String amount) {
        try {
            return new Amount(Integer.parseInt(amount));
        }catch (NumberFormatException exception) {
            throw new AmountNumberFormatException();
        }
    }

    public static Products parseProducts(String products) {
        String[] product = products.split(";");
        return new Products(Arrays.stream(product).map(Parser::parseProduct).collect(Collectors.toList()));
    }

    private static Product parseProduct(String product) {
        if (product.toCharArray().length <= 2) {
            throw new ProductFormatException();
        }
        if (!(product.charAt(0) == '[' && product.charAt(product.length() - 1) == ']')) {
            throw new ProductFormatException();
        }
        String replaced = product.replace("[", "").replace("]", "");
        String[] productInfo = replaced.split(",");
        if (productInfo.length != 3) {
            throw new ProductFormatException();
        }
        return new Product(
                new Name(productInfo[0]),
                parsePrice(productInfo[1]),
                parseQuantity(productInfo[2])
        );
    }

    private static Price parsePrice(String price) {
        try {
            return new Price(Integer.parseInt(price));
        }catch (NumberFormatException exception) {
            throw new PriceNumberFormatException();
        }
    }

    private static Quantity parseQuantity(String quantity) {
        try {
            return new Quantity(Integer.parseInt(quantity));
        }catch (NumberFormatException exception) {
            throw new QuantityNumberFormatException();
        }
    }

    public static Order parseOrder(String productName) {
        return new Order(new Name(productName));
    }
}
