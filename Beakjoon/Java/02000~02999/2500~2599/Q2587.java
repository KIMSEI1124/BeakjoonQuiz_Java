import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q2587 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>(Collections.emptyList());
        for (int i = 0; i < 5; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list = list.stream().sorted().collect(Collectors.toList());
        int avg = (int) list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        int mid = list.get(list.size() / 2);
        System.out.println(avg + "\n" + mid);
    }
}