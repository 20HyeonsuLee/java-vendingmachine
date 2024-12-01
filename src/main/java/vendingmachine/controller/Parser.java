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

    private static final String PRODUCT_SEPARATOR = ";";
    private static final char PRODUCT_START_WITH_CHAR = '[';
    private static final char PRODUCT_END_WITH_CHAR = ']';
    private static final String PRODUCT_START_WITH_STRING = "[";
    private static final String PRODUCT_END_WITH_STRING = "]";
    private static final String PRODUCT_INFO_SEPARATOR = ",";
    private static final int MIN_PRODUCT_INFO_STRING_SIZE = 2;
    private static final int PRODUCT_INFO_SIZE = 3;
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_PRICE_INDEX = 1;
    private static final int PRODUCT_QUANTITY_INDEX = 2;


    private Parser() {
    }

    public static MachineAmount parseMachineAmount(String amount) {
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
        String[] product = products.split(PRODUCT_SEPARATOR);
        return new Products(Arrays.stream(product).map(Parser::parseProduct).collect(Collectors.toList()));
    }

    private static Product parseProduct(String product) {
        validateProductString(product);
        String replaced = product.replace(PRODUCT_START_WITH_STRING, "").replace(PRODUCT_END_WITH_STRING, "");
        String[] productInfo = replaced.split(PRODUCT_INFO_SEPARATOR);
        validateProductInfo(productInfo);
        return new Product(
                new Name(productInfo[PRODUCT_NAME_INDEX]),
                parsePrice(productInfo[PRODUCT_PRICE_INDEX]),
                parseQuantity(productInfo[PRODUCT_QUANTITY_INDEX])
        );
    }

    private static void validateProductInfo(String[] productInfo) {
        if (productInfo.length != PRODUCT_INFO_SIZE) {
            throw new ProductFormatException();
        }
    }

    private static void validateProductString(String product) {
        if (product.toCharArray().length <= MIN_PRODUCT_INFO_STRING_SIZE) {
            throw new ProductFormatException();
        }
        if (!(product.charAt(0) == PRODUCT_START_WITH_CHAR && product.charAt(product.length() - 1) == PRODUCT_END_WITH_CHAR)) {
            throw new ProductFormatException();
        }
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
