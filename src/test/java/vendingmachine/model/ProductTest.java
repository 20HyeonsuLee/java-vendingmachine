package vendingmachine.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {
    
    @Test
    void 가진_금액으로_제품을_구매할수_없으면_false를_반환한다() {
        assertSimpleTest(() -> {
            Product product = new Product(
                    new Name("콜라"),
                    new Price(1500),
                    new Quantity(10)
            );
            assertThat(product.isBuyable(new Amount(1400))).isFalse();
        });
    }

    @Test
    void 가진_금액으로_제품을_구매할수_있으면_true를_반환한다() {
        assertSimpleTest(() -> {
            Product product = new Product(
                    new Name("콜라"),
                    new Price(1500),
                    new Quantity(10)
            );
            assertThat(product.isBuyable(new Amount(1600))).isTrue();
        });
    }

    @Test
    void 재고가_충분하지_않으면_false를_반환한다() {
        assertSimpleTest(() -> {
            Product product = new Product(
                    new Name("콜라"),
                    new Price(1500),
                    new Quantity(1)
            );
            product.decreaseQuantity();
            assertThat(product.isEnoughQuantity()).isFalse();
        });
    }

    @Test
    void 재고가_충분하면_true를_반환한다() {
        assertSimpleTest(() -> {
            Product product = new Product(
                    new Name("콜라"),
                    new Price(1500),
                    new Quantity(10)
            );
            assertThat(product.isEnoughQuantity()).isTrue();
        });
    }
}
