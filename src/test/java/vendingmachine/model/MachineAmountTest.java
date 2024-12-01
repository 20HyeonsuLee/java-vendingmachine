package vendingmachine.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MachineAmountTest {
    
    @Test
    void 자판기의_잔돈은_0원보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            MachineAmount machineAmount = new MachineAmount(-2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자판기의_잔돈은_10으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Amount amount = new Amount(10);
            amount.decrease(15);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
