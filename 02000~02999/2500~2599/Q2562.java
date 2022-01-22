import java.util.*;

@SuppressWarnings({ "rawtypes", "unchecked" })

public class Q2562 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Vector<Integer> vt = new Vector<>();
        input(vt);
        solve(vt);
    }

    public static void input(Vector vt) {
        for (int i = 1; i <= 9; i++) {
            vt.add(sc.nextInt());
        }
    }

    public static void solve(Vector vt) {
        int max = (int) Collections.max(vt);
        int pos = vt.indexOf(max)+1;
        System.out.println(max + "\n" + pos);
    }
}