package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NameTest {
    
    @Test
    void 상품_이름은_공백일_수_없다() {
        assertThatThrownBy(() -> {
            Name name = new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
