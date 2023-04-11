import java.math.BigInteger;
import java.util.Scanner;

public class Q10757 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());
        BigInteger sum = A.add(B);
        System.out.println(sum);
    }
}