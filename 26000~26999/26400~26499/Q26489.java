import java.io.*;

public class Q26489 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = 0;
        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            count++;
        }
        System.out.println(count);
    }
}