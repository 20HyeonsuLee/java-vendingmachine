package vendingmachine.view;

import java.util.List;

public enum OutputMessage {

    OUTPUT_MACHINE_COIN_TITLE("자판기가 보유한 동전"),
    OUTPUT_MACHINE_COIN_DETAIL("%d원 - %d개"),
    OUTPUT_AMOUNT("투입 금액: %d원"),
    OUTPUT_CHANGE_TITLE("잔돈"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void print(Object... values) {
        System.out.println(format(values));
    }

    public String format(Object... values) {
        return String.format(message, values);
    }

    public String format(List<String> values) {
        return String.format(message, values.toArray());
    }
}
