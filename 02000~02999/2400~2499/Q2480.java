import java.io.*;
import java.util.*;

public class Q2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> dice = new HashMap<>();
        int index = 6;
        int money = 0;
        int max = 0;
        while (index > 0) {
            dice.put(index, 0);
            index--;
        }
        while (st.hasMoreTokens()) {
            int diceNum = Integer.parseInt(st.nextToken());
            if( diceNum > max) {
                max = diceNum;
            }
            dice.replace(diceNum, dice.get(diceNum) + 1);
        }
        if (dice.containsValue(3)) {
            money = 1000 * getKey(dice, 3) + 10000;
        } else if (dice.containsValue(2)) {
            money = 100 * getKey(dice, 2) + 1000;
        } else {
            money = max * 100;
        }
        System.out.println(money);
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}