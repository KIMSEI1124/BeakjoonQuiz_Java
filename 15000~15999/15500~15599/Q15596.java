public class Q15596 {       // 제출시 클래스 이름은 Test

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(sum(a));
    }

    private static long sum(int[] a) {
        long result = 0L;
        for (int value : a) {
            result += value;
        }
        return result;
    }
}