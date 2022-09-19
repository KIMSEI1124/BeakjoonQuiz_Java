import java.io.*;
import java.util.*;

public class test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0, ans2 = 0;
    static StringTokenizer st, st2, st3;
    static int N;
    static int[] factory;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        st = new StringTokenizer(str);
        st2 = new StringTokenizer(str);
        st3 = new StringTokenizer(str);
        solve1(N, st);
        solve2(N, st2);
        solve3(N, st3);
    }

    public static void solve1(int N, StringTokenizer st) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        // StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        int value = 0;
        for (int i = 0; i < N; i++) {
            int cur = stack.pop();
            while (cur == 0) {
                if (stack.isEmpty())
                    break;
                cur = stack.pop();
            }
            if (stack.isEmpty() || stack.peek() == 0) {
                value += 3 * cur;
                stack.push(0);
            } else {
                int secCur = stack.pop();
                if (stack.isEmpty() || stack.peek() == 0) {
                    for (int j = 0; j < Math.min(secCur, cur); j++) {
                        value += 5;
                        secCur--;
                        cur--;
                    }
                } else {
                    int thrCur = stack.pop();
                    while (Math.min(Math.min(cur, secCur), thrCur) != 0) {
                        value += 7;
                        secCur--;
                        thrCur--;
                        cur--;
                    }
                    stack.push(thrCur);
                }
                stack.push(secCur);
                stack.push(cur);
            }
            if (stack.isEmpty()) {
                break;
            }
            System.out.println("value : " + value + ", stack : "+ stack);
        }
        System.out.println("작성자님의 답 : " + value);
    }

    public static void solve2(int N, StringTokenizer st) throws IOException {
        // input
        // N = Integer.parseInt(br.readLine());
        factory = new int[N];
        // st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        for (int i = 0; i < N;) {
            if (factory[i] != 0) {
                if (i + 1 < N && factory[i + 1] != 0) {
                    if (i + 2 < N && factory[i + 2] != 0) {
                        factory[i + 2]--;
                        ans += 7;
                        if (factory[i + 1] - 1 > factory[i + 2]) {
                            factory[i + 2]++;
                            ans -= 2;
                        }
                    } else {
                        ans += 5;
                    }
                    factory[i + 1]--;
                } else {
                    ans += 3;
                }
                factory[i]--;
                System.out.println("value : " + ans + ", arr : "+ Arrays.toString(factory));
            } else { // 공장에 라면이 존재하지 않을경우에만 증가
                i++;
            }
        }

        // output
        System.out.println("정답 : " + ans);
    }

    public static void solve3(int N, StringTokenizer st) {
        // N = Integer.parseInt(br.readLine());
        factory = new int[N];
        // st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        for (int i = N - 1; i >= 0;) {
            if (factory[i] != 0) {
                if (i - 1 >= 0 && factory[i - 1] != 0) {
                    if (i - 2 >= 0 && factory[i - 2] != 0) {
                        factory[i - 2]--;
                        ans2 += 7;
                        if (factory[i - 1] - 1 > factory[i - 2]) {
                            factory[i - 2]++;
                            ans2 -= 2;
                        }
                    } else {
                        ans2 += 5;
                    }
                    factory[i - 1]--;
                } else {
                    ans2 += 3;
                }
                factory[i]--;
                System.out.println("value : " + ans2 + ", arr : "+ Arrays.toString(factory));
            } else { // 공장에 라면이 존재하지 않을경우에만 증가
                i--;
            }
        }

        // output
        System.out.println("정답 : " + ans2);
    }
}