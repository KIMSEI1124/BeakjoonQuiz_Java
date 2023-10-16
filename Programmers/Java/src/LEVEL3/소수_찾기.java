package LEVEL3;

import java.util.HashSet;
import java.util.Set;

/**
 * 시간 : 16.57ms
 * 메모리 : 82.7MB
 */
public class 소수_찾기 {
    private int answer;
    private Set<Integer> set;
    private char[] numbers;
    private boolean[] isSelected;

    public int solution(String input) {
        init(input);
        solve();
        return answer;
    }

    private void init(String input) {
        set = new HashSet<>();
        numbers = input.toCharArray();
        isSelected = new boolean[input.length()];
    }

    private void solve() {
        search(0, new char[numbers.length]);
        for (int number : set) {
            if (isPrimeNumber(number)) {
                answer++;
            }
        }
    }

    private void search(int count, char[] array) {
        if (count == numbers.length + 1) {
            return;
        }

        addNumberToSet(count, array);

        for (int i = 0; i < numbers.length; i++) {
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            array[count] = numbers[i];
            search(count + 1, array);
            isSelected[i] = false;
        }
    }

    private void addNumberToSet(int count, char[] array) {
        if (count == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(array[i]);
        }
        set.add(Integer.parseInt(sb.toString()));
    }

    private boolean isPrimeNumber(int number) {
        if (number == 1 || number == 0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}