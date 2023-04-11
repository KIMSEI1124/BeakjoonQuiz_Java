import java.io.*;
import java.util.*;

public class Q1181 {
    static int N = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        list = input(list);
        Collections.sort(list);
        for (int i = 1; i <= 50; i++) {
            if (list.size() <= 0) {
                break;
            }
            for (int j = 0; j < list.size(); j++) {
                String str = list.get(j);
                if( str.length() == i ) {
                    sb.append(str+"\n");
                    list.remove(j);
                    j--;
                }
            }
        }
        System.out.println(sb);
    }

    public static ArrayList<String> input(ArrayList<String> list) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N > 0) {
            String str = br.readLine();
            if (!list.contains(str)) {
                list.add(str);
            }
            N--;
        }
        return list;
    }
}
