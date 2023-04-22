package LEVEL0;

public class 구슬을_나누는_경우의_수 {
    public int solution(int balls, int share) {
        int answer = balls;
        for (int i = balls - 1; i > 0; i--) {
            if(i > share) {
                answer *= i;
            } else if (i < share) {
                answer /= i;
            }
        }
        // 5 4 3
        // 3 * 2 * 1
        return answer;
    }
}
