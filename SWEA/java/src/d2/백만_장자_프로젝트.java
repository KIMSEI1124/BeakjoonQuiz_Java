package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class 백만_장자_프로젝트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int t;

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            getAnswer(test_case);
        }

        System.out.println(answer);
    }

    private static void getAnswer(int t) throws IOException {
        int size = Integer.parseInt(br.readLine());
        List<Integer> list = inputList();
        long total = 0L;
        long maxTotal = 0L;
        int max = 0;
        for (int i = size - 1; i >= 0; i--) {
            int value = list.get(i);
            total += value;
            if (isBiggerWithValue(max, value)) {
                max = value;
            }
            maxTotal += max;
        }
        long result = maxTotal - total;
        answer.append(String.format("#%d %d\n", t, result));
    }

    private static boolean isBiggerWithValue(int max, int value) {
        return value >= Math.max(max, value);
    }

    private static List<Integer> inputList() throws IOException {
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        return list;
    }
}