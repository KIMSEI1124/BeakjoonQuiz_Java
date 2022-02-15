import java.util.*;
public class Q1157 {
    static Scanner sc = new Scanner(System.in);
    static String str = sc.next();

    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        str.toUpperCase();
        String[] arr = str.split("");
        for (int i = 0; i < arr.length; i++) {
            if (hash.containsKey(arr[i]) == true) {
                int count = hash.get(arr[i]) + 1;
                hash.replace(arr[i], count);
            } else {
                hash.put(arr[i], 1);
            }
        }
    }
}