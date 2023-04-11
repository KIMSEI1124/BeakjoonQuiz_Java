import java.io.*;
import java.util.*;

public class Q3009 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int loop =3 ;
        while (loop-- > 0) {
            st = new StringTokenizer(br.readLine());
            x.add(Integer.parseInt(st.nextToken()));
            y.add(Integer.parseInt(st.nextToken()));
        }
        answer.append(getCount(x) + " " + getCount(y));
        System.out.println(answer);
    }

    private static int getCount(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        for (Integer integer : list) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
            if(!temp.contains(integer)) {
                temp.add(integer);
            }
        }
        for (Integer integer : temp) {
            if(map.get(integer) == 1) {
                return integer;
            }
        }
        return 0;
    }
}