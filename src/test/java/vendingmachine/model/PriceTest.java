package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PriceTest {
    
    @Test
    void 제품의_가격은_100원_이상이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Price price = new Price(90);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 제품의_가격은_10으로_나누어_떨어지지_않으면_예외를_발생한다() {
        assertThatThrownBy(() -> {
            Price price = new Price(91);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
