package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

class ChangeTest {
    
    @Test
    void 자판기의_잔돈을_반환한다() {
        Assertions.assertSimpleTest(() -> {
            Change change = new Change(new MachineAmount(450));
            assertThat(change.getTotalChange()).isEqualTo(450);
        });
    }

    @Test
    void 자판기에_금액을_입력하면_동전으로_환산한다() {
        Assertions.assertSimpleTest(() -> {
            Change change = new Change(new MachineAmount(450));
            assertThat(change.getChangeMoney().get(Coin.COIN_500)).isZero();
            assertThat(change.getChangeMoney().get(Coin.COIN_100)).isEqualTo(4);
            assertThat(change.getChangeMoney().get(Coin.COIN_50)).isEqualTo(1);
            assertThat(change.getChangeMoney().get(Coin.COIN_10)).isZero();
        });
        assertThatThrownBy(() -> {
            MachineAmount machineAmount = new MachineAmount(-2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
