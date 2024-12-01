package vendingmachine.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputBuyAmount() {
        InputMessage.INPUT_BUY_AMOUNT.print();
        return Console.readLine();
    }

    public String inputBuyProductName() {
        InputMessage.INPUT_BUY_PRODUCT_NAME.print();
        return Console.readLine();
    }

    public String inputMachineAmount() {
        InputMessage.INPUT_MACHINE_AMOUNT.print();
        return Console.readLine();
    }

    public String inputProducts() {
        InputMessage.INPUT_PRODUCTS.print();
        return Console.readLine();
    }
}
