package vendingmachine.exception;

public enum ExceptionMessage {

    PRICE_NUMBER_FORMAT("가격은 숫자여야 합니다."),
    AMOUNT_NUMBER_FORMAT("금액은 숫자여야 합니다."),
    QUANTITY_NUMBER_FORMAT("수량은 숫자여야 합니다."),
    AMOUNT_FORMAT("금액은 10으로 나누어 떨어지며 0 이상이여야 합니다."),
    PRODUCT_PRICE_FORMAT("상품 가격은 100원 이상 10으로 나누어 떨어져야 합니다."),
    PRODUCT_FORMAT("상품 입력 형식을 확인해주세요."),
    PRODUCT_QUANTITY_FORMAT("상품의 개수는 0개 이상이여야 합니다."),
    PRODUCT_NAME_NOT_BLANK("상품의 이름은 공백일 수 없습니다."),
    PRODUCT_NAME_NOT_FOUND("존재하지 않는 상품입니다."),
    PRODUCT_QUANTITY_NOT_ENOUGH("재고가 부족합니다."),
    AMOUNT_NOT_ENOUGH("금액이 부족합니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
