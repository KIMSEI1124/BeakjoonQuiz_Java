import java.util.*;
// 시간 초과 BufferReader 사용 해야할듯..

@SuppressWarnings({ "rawtypes", "unchecked" })

public class Q10989 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        input(list);
        solve(list);
    }

    public static ArrayList input(ArrayList list) {
        while (N > 0) {
            list.add(sc.nextInt());
            N--;
        }
        return list;
    }

    public static void solve(ArrayList list) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)+"\n");
        }
        System.out.println(sb);
    }
}