import java.io.*;
import java.util.*;

public class Q10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        List<Integer> Deque = new ArrayList<>();
        // solve
        while (N > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push_front")) {
                int value = Integer.parseInt(st.nextToken());
                Deque = push_front(Deque, value);
            } else if (str.equals("push_back")) {
                int value = Integer.parseInt(st.nextToken());
                Deque = push_back(Deque, value);
            } else if (str.equals("pop_front")) {
                Deque = pop_front(Deque);
            } else if (str.equals("pop_back")) {
                Deque = pop_back(Deque);
            } else if (str.equals("size")) {
                size(Deque);
            } else if (str.equals("empty")) {
                empty(Deque);
            } else if (str.equals("front")) {
                front(Deque);
            } else if (str.equals("back")) {
                back(Deque);
            }
            N--;
        }
        // output
        System.out.println(ans);
    }

    // push_front X: 정수 X를 덱의 앞에 넣는다.
    public static List<Integer> push_front(List<Integer> Deque, int value) {
        Deque.add(0, value);
        return Deque;
    }

    // push_back X: 정수 X를 덱의 뒤에 넣는다.
    public static List<Integer> push_back(List<Integer> Deque, int value) {
        Deque.add(value);
        return Deque;
    }

    // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static List<Integer> pop_front(List<Integer> Deque) {
        if (Deque.isEmpty()) {
            ans.append("-1").append("\n");
        } else {
            ans.append(Deque.get(0)).append("\n");
            Deque.remove(0);
        }
        return Deque;
    }

    // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static List<Integer> pop_back(List<Integer> Deque) {
        if (Deque.isEmpty()) {
            ans.append("-1").append("\n");
        } else {
            int idx = Deque.size() - 1;
            ans.append(Deque.get(idx)).append("\n");
            Deque.remove(idx);
        }
        return Deque;
    }

    // size: 덱에 들어있는 정수의 개수를 출력한다.
    public static void size(List<Integer> Deque) {
        int size = Deque.size();
        ans.append(size).append("\n");
    }

    // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    public static void empty(List<Integer> Deque) {
        if (Deque.isEmpty()) {
            ans.append("1").append("\n");
        } else {
            ans.append("0").append("\n");
        }
    }

    // front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void front(List<Integer> Deque) {
        try {
            int idx = Deque.get(0);
            ans.append(idx).append("\n");
        } catch (Exception e) {
            ans.append("-1").append("\n");
        }
    }

    // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void back(List<Integer> Deque) {
        try {
            int idx = Deque.get(Deque.size() - 1);
            ans.append(idx).append("\n");
        } catch (Exception e) {
            ans.append("-1").append("\n");
        }
    }
}