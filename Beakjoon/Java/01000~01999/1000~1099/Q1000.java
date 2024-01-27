import java.io.*;
import java.util.*;

public class Q1000 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// input
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		// solve
		int ans = A + B;
		// output
		System.out.println(ans);
	}
}