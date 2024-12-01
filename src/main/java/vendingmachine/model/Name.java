package vendingmachine.model;

import java.util.Objects;
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

    public String getName() {
        return name;
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
        return Objects.equals(getName(), otherName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
