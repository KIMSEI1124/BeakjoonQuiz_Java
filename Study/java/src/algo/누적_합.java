package algo;

import java.util.Arrays;

public class 누적_합 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] prefixSumArray = getPrefixSumArray(array);

        System.out.printf("%-15s : " + Arrays.toString(array) + "\n", "array");
        System.out.printf("%-15s : " + Arrays.toString(prefixSumArray), "prefixSumArray");
    }

    private static int[] getPrefixSumArray(int[] array) {
        int[] prefixSumArray = new int[array.length + 1];
        for (int i = 1; i <= array.length; i++) {
            prefixSumArray[i] = array[i - 1] + prefixSumArray[i - 1];
        }
        return prefixSumArray;
    }
}
