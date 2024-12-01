package vendingmachine.model;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingMachineTest {

    private VendingMachine vendingMachine;
    private Products products;

    @BeforeEach
    void setup() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(
                new Name("콜라"),
                new Price(1500),
                new Quantity(10)
        ));
        productList.add(new Product(
                new Name("사이다"),
                new Price(100),
                new Quantity(30)
        ));
        products = new Products(productList);
        Change change = new Change(new MachineAmount(450));
        Amount amount = new Amount(3000);
        vendingMachine = new VendingMachine(change, products, amount);
    }

    @Test
    void 잔돈을_반환한다_잔돈이_부족한경우_모든_잔돈을_반환한다() {
        assertSimpleTest(() -> {
            assertThat(vendingMachine.getChange().getTotalChange()).isEqualTo(450);
        });
    }

    @Test
    void 잔돈이_부족하지_않은_경우_게산하여_반환한다() {
        assertSimpleTest(() -> {
            IntStream.range(0, 27).forEach(i -> vendingMachine.buy(new Order(new Name("사이다"))));
            assertThat(vendingMachine.getChange().getTotalChange()).isEqualTo(300);
        });
    }

    @Test
    void 구매_가능한_상품이_있다면_true를_반환한다() {
        assertSimpleTest(() -> {
            assertThat(vendingMachine.isBuyableAnyProduct()).isTrue();
        });
    }

    @Test
    void 구매_가능한_상품이_없다면_false를_반환한다() {
        assertSimpleTest(() -> {
            IntStream.range(0, 30).forEach(i -> vendingMachine.buy(new Order(new Name("사이다"))));
            assertThat(vendingMachine.isBuyableAnyProduct()).isFalse();
        });
    }

    @Test
    void 상품을_구매한다() {
        assertSimpleTest(() -> {
            vendingMachine.buy(new Order(new Name("사이다")));
            assertThat(vendingMachine.getAmount()).isEqualTo(2900);
            assertThat(products.find(new Name("사이다")).get().getQuantity()).isEqualTo(29);
        });
    }
}
