package vendingmachine.model;

import java.util.Objects;
import vendingmachine.exception.ProductNameNotBlankException;

public class Name {
    private final String value;

    public Name(String name) {
        validateName(name);
        this.value = name;
    }

    private void validateName(String name) {
        if (name.replace(" ","").isEmpty()) {
            throw new ProductNameNotBlankException();
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Name)) {
            return false;
        }
        Name otherName = (Name) other;
        return Objects.equals(getValue(), otherName.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
