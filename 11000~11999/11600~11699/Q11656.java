import java.io.*;
import java.util.*;

public class Q11656 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i));
        }
        Collections.sort(list);
        for (String string : list) {
            answer.append(string).append("\n");
        }
        System.out.println(answer);
    }
}