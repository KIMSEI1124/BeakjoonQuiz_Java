package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 암호문3 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m; // 암호문의 개수, 명령어의 개수
    private static List<String> passwords;

    public static void main(String[] args) throws IOException {
        for (int testCase = 1; testCase <= 10; testCase++) {
            answer.append("#").append(testCase).append(" ").append(getResult()).append("\n");
        }

        System.out.println(answer);
    }

    private static String getResult() throws IOException {
        input();
        return solve();
    }

    private static void input() throws IOException {
        passwords = new LinkedList<>();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            passwords.add(st.nextToken());
        }
    }

    private static String solve() throws IOException {
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            runCode(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(passwords.get(i)).append(" ");
        }
        return sb.toString();
    }

    private static void runCode(String code) {
        if (code.equals("I")) {
            insert();
            return;
        }
        if (code.equals("D")) {
            delete();
            return;
        }
        if (code.equals("A")) {
            add();
        }
    }

    /* I(삽입) x, y, s : 앞에서부터 x번째 암호문 바로 다음에 y개의 암호문을 삽입한다. s는 덧붙일 암호문들이다.[ ex) I 3 2 123152 487651 ] */
    private static void insert() {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < y; i++) {
            passwords.add(x++, st.nextToken());
        }
    }

    /* D(삭제) x, y : 앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.[ ex) D 4 4 ] */
    private static void delete() {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        while (y-- > 0) {
            passwords.remove(x);
        }
    }

    /* A(추가) y, s : 암호문 뭉치 맨 뒤에 y개의 암호문을 덧붙인다. s는 덧붙일 암호문들이다. [ ex) A 2 421257 796813 ] */
    private static void add() {
        int y = Integer.parseInt(st.nextToken());
        while (y-- > 0) {
            passwords.add(st.nextToken());
        }
    }
}
