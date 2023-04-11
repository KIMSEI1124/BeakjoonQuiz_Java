import java.io.*;
import java.util.*;

public class Q11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static boolean[] empty_set;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        empty_set = new boolean[21];
        // solve
        while (N > 0) {
            st = new StringTokenizer(br.readLine());
            int st_size = st.countTokens();
            String op;
            int id;
            if (st_size == 2) {
                op = st.nextToken();
                id = Integer.parseInt(st.nextToken());
                if (op.equals("add")) {
                    add(id);
                } else if (op.equals("remove")) {
                    remove(id);
                } else if (op.equals("check")) {
                    check(id);
                } else { // toggle
                    toggle(id);
                }
            } else {
                op = st.nextToken();
                if (op.equals("all")) {
                    all();
                } else { // empty
                    empty();
                }
            }
            N--;
        }
        // output
        System.out.println(ans);
    }

    public static void add(int id) {
        empty_set[id] = true;
    }

    public static void remove(int id) {
        empty_set[id] = false;
    }

    public static void check(int id) {
        if (empty_set[id] == true) {
            ans.append("1\n");
        } else {
            ans.append("0\n");
        }
    }

    public static void toggle(int id) {
        if (empty_set[id] == true) {
            empty_set[id] = false;
        } else {
            empty_set[id] = true;
        }
    }

    public static void all() {
        for (int i = 1; i < 21; i++) {
            add(i);
        }
    }

    public static void empty() {
        empty_set = new boolean[21];
    }
}