package vendingmachine.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductsTest {

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
                new Price(1000),
                new Quantity(10)
        ));
        products = new Products(productList);
    }

    @Test
    void 존재하는_상품을_조회한다() {
        assertSimpleTest(() -> {
            assertThat(products.find(new Name("콜라"))).isPresent();
        });
    }

    @Test
    void 존재하지_않는_상품을_조회한다() {
        assertSimpleTest(() -> {
            assertThat(products.find(new Name("콜라1"))).isNotPresent();
        });
    }

    @Test
    void 가장_저렴한_상품의_가격을_조회한다() {
        assertSimpleTest(() -> assertThat(products.findMinPrice()).isEqualTo(1000));
    }

    @Test
    void 구매_가능한_상품이_없을_때_개수를_계산한다() {
        assertSimpleTest(() -> {
            List<Product> productList = new ArrayList<>();
            productList.add(new Product(
                    new Name("콜라"),
                    new Price(1500),
                    new Quantity(10)
            ));
            productList.add(new Product(
                    new Name("사이다"),
                    new Price(1000),
                    new Quantity(10)
            ));
            products = new Products(productList);
            assertThat(products.buyableProductCount(500)).isZero();
        });
    }

    @Test
    void 구매_가능한_상품이_있을_때_개수를_계산한다() {
        assertSimpleTest(() -> {
            List<Product> productList = new ArrayList<>();
            productList.add(new Product(
                    new Name("콜라"),
                    new Price(1500),
                    new Quantity(10)
            ));
            productList.add(new Product(
                    new Name("사이다"),
                    new Price(1000),
                    new Quantity(10)
            ));
            products = new Products(productList);
            assertThat(products.buyableProductCount(1000)).isEqualTo(1);
        });
    }
}
