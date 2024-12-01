package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Change {
    private final Map<Coin, Integer> changeMoney = new LinkedHashMap<>();

    public Change(int money) {
        int remainMoney = money;
        for (Coin coin : Coin.values()) {
            int coinCount = remainMoney % coin.getAmount();
            changeMoney.put(coin, coinCount);
            remainMoney -= coin.getAmount() * coinCount;
        }
    }
}
