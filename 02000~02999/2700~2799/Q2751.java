import java.util.*;

@SuppressWarnings({ "rawtypes", "unchecked" })

public class Q2751 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    public static void main(String[] args) {
        HashSet<Integer> hash = new HashSet<>();
        input(hash);
        solve(hash);
    }

    public static HashSet input(HashSet hash) {
        while (N > 0) {
            hash.add(sc.nextInt());
            N--;
        }
        return hash;
    }

    public static void solve(HashSet hash) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> sortList = new ArrayList<>(hash);
        Collections.sort(sortList);
        for (int i = 0; i < sortList.size(); i++) {
            sb.append(sortList.get(i) + "\n");
        }
        System.out.println(sb);
    }
}