package vendingmachine.model;

import vendingmachine.exception.ProductNameNotBlankException;

public class Name {
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.replace(" ","").isEmpty()) {
            throw new ProductNameNotBlankException();
        }
    }
}
