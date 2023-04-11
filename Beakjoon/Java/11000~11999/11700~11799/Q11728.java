import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q11728 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        br.readLine();
        List<Integer> list = getList();
        list.addAll(getList());
        String answer = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ", "", ""));
        System.out.println(answer);
    }

    private static List<Integer> getList() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}