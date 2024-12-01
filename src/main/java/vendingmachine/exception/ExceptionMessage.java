package vendingmachine.exception;

public enum ExceptionMessage {

    PRICE_NUMBER_FORMAT("가격은 숫자여야 합니다."),
    AMOUNT_NUMBER_FORMAT("금액은 숫자여야 합니다."),
    PRODUCT_PRICE_FORMAT("상품 가격은 100원 이상 10으로 나누어 떨어져야 합니다."),
    PRODUCT_QUANTITY_FORMAT("상품의 개수는 0개 이상이여야 합니다."),
    PRODUCT_NAME_NOT_BLANK("상품의 이름은 공백일 수 없습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
