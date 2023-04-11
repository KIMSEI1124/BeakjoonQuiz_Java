import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // O의 개수
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String IOI = getIOI(N);
        System.out.println(getResult(IOI, str));
    }

    private static String getIOI(int N) {
        StringBuilder sb = new StringBuilder("I");
        while (N-- > 0) {
            sb.append("OI");
        }
        return String.valueOf(sb);
    }

    private static int getResult(String IOI, String str) {
        int result = 0;
        for (int i = 0; i < str.length() - IOI.length() + 1; i++) {
            String temp = str.substring(i, i + IOI.length());
            if (IOI.equals(temp)) {
                result++;
                // int count = getCount(i, IOI, str);
                // i += (count * 2) - 1;
            }
        }
        return result;
    }

    // TODO : 시간복잡도 문제 해결중
    private static int getCount(int i, String IOI, String str) {
        int count = 0;
        for (int j = i + IOI.length(); j < str.length() - IOI.length(); j++) {
            String temp = str.substring(i, i+2);
            if(!temp.equals("OI")) {
                break;
            }
            count++;
        }
        return count;
    }
}