import java.io.*;
import java.util.*;

public class Q3107 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        List<String> IPv6 = new ArrayList<>();
        String ip = br.readLine();
        st = new StringTokenizer(ip, ":");
        while(st.hasMoreTokens()) {
            IPv6.add(getNormal(st.nextToken()));
        }
        System.out.println(IPv6);
    }

    private static String getNormal(String ip) {
        if (ip.length() == 4) {
            return ip;
        }
        String newIp = "";
        for (int i = 4 - ip.length(); i > 0; i--) {
            newIp += "0";
        }
        newIp += ip;
        return newIp;
    }
}