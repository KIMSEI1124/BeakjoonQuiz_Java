package algo;

public class 재귀_함수 {
    public static void main(String[] args) {
        System.out.println(fibo(10));
    }

    private static int fibo(int n) {
        /* 종료 조건 */
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
