package vendingmachine.controller;

import java.util.function.Supplier;
import vendingmachine.dto.ChangeDto;
import vendingmachine.exception.IllegalArgumentBaseException;
import vendingmachine.model.Amount;
import vendingmachine.model.Change;
import vendingmachine.model.MachineAmount;
import vendingmachine.model.Order;
import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private VendingMachineService vendingMachineService;

    public void run() {
        Change change = handleInput(this::inputMachineAmount);
        outputView.printMachineState(new ChangeDto(change));
        Products products = handleInput(this::inputProducts);
        Amount amount = handleInput(this::inputAmount);
        vendingMachineService = new VendingMachineService(new VendingMachine(change, products, amount));
        buy();

    }

    private void buy() {
        while(vendingMachineService.isBuyable()) {
            buyProduct();
        }
        printResultChange();
    }

    private void printResultChange() {
        outputView.printRemainAmount(vendingMachineService.getAmount());
        outputView.printChange(vendingMachineService.getChange());
    }

    private void buyProduct() {
        outputView.printRemainAmount(vendingMachineService.getAmount());
        handleInput(() -> vendingMachineService.buy(inputOrder()));
    }

    private Order inputOrder() {
        return Parser.parseOrder(inputView.inputBuyProductName());
    }

    private Amount inputAmount() {
        return Parser.parseAmount(inputView.inputBuyAmount());
    }

    private Change inputMachineAmount() {
        MachineAmount amount = Parser.parseAmountInt(inputView.inputMachineAmount());
        return new Change(amount);
    }

    private Products inputProducts() {
        return Parser.parseProducts(inputView.inputProducts());
    }

    private <T> T handleInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentBaseException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void handleInput(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentBaseException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
