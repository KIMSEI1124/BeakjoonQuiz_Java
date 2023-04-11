import java.io.*;
import java.util.*;

public class Q10821 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), ",");
        int count = st.countTokens();
        System.out.println(count);
    }
}