package vendingmachine.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

class AmountTest {
    
    @Test
    void 자판기_투입_금액은_10으로_나누어_떨어지지_않으면_예외를_발생한다() {
        assertThatThrownBy(() -> {
            Amount amount = new Amount(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자판기에_남은_금액보다_많이_사용하면_예외를_발생한다() {
        assertThatThrownBy(() -> {
            Amount amount = new Amount(10);
            amount.decrease(15);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자판기_투입_금액을_사용한다() {
        assertSimpleTest(() -> {
            Amount amount = new Amount(10);
            amount.decrease(5);
            assertThat(amount.getAmount()).isEqualTo(5);
        });
    }
}
