package vendingmachine.view;

import static vendingmachine.view.OutputMessage.OUTPUT_AMOUNT;
import static vendingmachine.view.OutputMessage.OUTPUT_CHANGE_TITLE;
import static vendingmachine.view.OutputMessage.OUTPUT_MACHINE_COIN_DETAIL;
import static vendingmachine.view.OutputMessage.OUTPUT_MACHINE_COIN_TITLE;

import vendingmachine.dto.ChangeDto;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printMachineState(ChangeDto changeDto) {
        StringBuilderPrinter printer = new StringBuilderPrinter();
        printer.appendLine(OUTPUT_MACHINE_COIN_TITLE.getMessage());
        changeDto.getChange().forEach((coin, count) ->
                printer.appendLine(OUTPUT_MACHINE_COIN_DETAIL.format(coin, count))
        );
        printer.print();
    }

    public void printChange(ChangeDto changeDto) {
        StringBuilderPrinter printer = new StringBuilderPrinter();
        printer.appendLine(OUTPUT_CHANGE_TITLE.getMessage());
        changeDto.getChange().forEach((coin, count) ->
                printer.appendLine(OUTPUT_MACHINE_COIN_DETAIL.format(coin, count))
        );
        printer.print();
    }

    public void printRemainAmount(int amount) {
        OUTPUT_AMOUNT.print(amount);
    }
}
