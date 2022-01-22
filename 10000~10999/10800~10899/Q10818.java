import java.util.ArrayList;
import java.util.*;

public class Q10818 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        input(arr);
        solve(arr);
    }

    public static void input(ArrayList arr) {
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            arr.add(sc.nextInt());
        }
    }

    public static void solve(ArrayList arr) {
        int max = (int) Collections.max(arr);
        int min = (int) Collections.min(arr);
        System.out.print(min+"\n"+max);
    }
}
