package vendingmachine.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class QuantityTest {

    @Test
    void 재고를_감소시킨다() {
        assertSimpleTest(() -> {
            Quantity quantity = new Quantity(1);
            quantity.decrease();
            assertThat(quantity.getQuantity()).isZero();
        });
    }
}
