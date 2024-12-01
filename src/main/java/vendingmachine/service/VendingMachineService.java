package vendingmachine.service;

import vendingmachine.dto.ChangeDto;
import vendingmachine.model.Order;
import vendingmachine.model.VendingMachine;

public class VendingMachineService {

    private final VendingMachine vendingMachine;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public boolean isBuyable() {
        return vendingMachine.isBuyableAnyProduct();
    }

    public void buy(Order order) {
        vendingMachine.buy(order);
    }

    public int getAmount() {
        return vendingMachine.getAmount();
    }

    public ChangeDto getChange() {
        return new ChangeDto(vendingMachine.getChange());
    }
}
