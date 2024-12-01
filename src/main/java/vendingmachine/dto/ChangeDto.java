package vendingmachine.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.model.Change;

public class ChangeDto {
    private final Map<Integer, Integer> change = new LinkedHashMap<>();

    public ChangeDto(Change change) {
        change.getChangeMoney().forEach(((coin, count) -> this.change.put(coin.getAmount(), count)));
    }

    public Map<Integer, Integer> getChange() {
        return change;
    }
}
