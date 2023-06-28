package algo;

import java.util.Arrays;

public class 순열 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        do {
            System.out.println(Arrays.toString(array));
        } while (nextPermutation(array));
    }

    private static boolean nextPermutation(int[] array) {
        int length = array.length - 1;
        int i = length;

        /* 1. 맨 뒤부터 탐색하며, 교환할 위치를 찾습니다. */
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        /* 다음 순열이 없는 경우이기 때문에 false 를 반환합니다. */
        if (i == 0) {
            return false;
        }

        /* 2. 내가 찾은 교환위치와 교환할 큰 값을 찾는 과정입니다. */
        int j = length;
        while (array[i - 1] >= array[j]) {
            j--;
        }

        /* 3.교환 위치와 교환할 큰 값을 교환합니다. */
        swap(array, i - 1, j);

        /* 4. i 번째 인덱스부터 맨 마지막 인덱스의 배열 값을 오름차순으로 바꿔주는 작업을 합니다. */
        int k = length;
        while (i < k) {
            swap(array, i++, k--);
        }

        return true;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

