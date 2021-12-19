import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        int currentSum = targetSum;

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int idx = coins.length - 1;

        while (currentSum > 0 && idx >= 0) {
            int coin = coins[idx];
            if(currentSum - coin >=0){
                int coinsToRemove = currentSum / coin;
                currentSum = currentSum % coin;
                map.put(coin, coinsToRemove);
            }
            idx = idx -1;
        }
        if(currentSum == 0){
            return map;
        }
        return null;
    }
}