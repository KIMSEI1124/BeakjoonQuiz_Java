import java.io.*;
import java.util.*;

public class BlackjackEx1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("딜러가 외치는 숫자는?");

        int M = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        System.out.println("딜러가 외친 숫자: " + M);
        System.out.println("딜러가 바닥에 놓은 카드 개수: " + N);

        Random ran = new Random();

        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

        int i = 0;

        while (i < N) {
            int data = ran.nextInt(300000) + 1;
            if (data <= 100000) {
                list.add(data);
                // hash.put(data, data); // 주소와 값 모두 같은 값으로 줌
                i++;
            }
        } // 바닥에 놓인 숫자 랜덤으로 도출
        System.out.println(list); // 바닥에 놓인 숫자

        List<Integer> result = new ArrayList<Integer>();

        for (Integer num : list) {
            int comparison = Math.abs(num - M); // M에 가까운 값으로 정렬을 위해 절대값 사용
            hash.put(num, comparison); // list의 값을 key로 두고 M을 뺀 값을 value로 둠
            result.add(comparison); // 값을 비교하기 위해 list 새로 생성(M을 뺀 값 리스트)
        }
        Collections.sort(result); // 오름차순 정렬

        List<Integer> numbers = new ArrayList<Integer>();

        int sum = 0;

        for (int j = 0; j < Math.min(result.size(), 3); j++) {
            for (var entry : hash.entrySet()) { // hash에서 값 가져오기
                if (entry.getValue() == result.get(j)) {
                    numbers.add(entry.getKey()); // 바닥의 숫자 중 M에 가까운 3개
                    sum += entry.getKey();
                    break;
                }
            }
            if (sum > M) {
                sum -= numbers.remove(numbers.size() - 1);
                break;
            }
        }
        System.out.println("가장 가까운 수 3개: " + numbers);
        System.out.println("가장 가까운 수 3개 합: " + sum);
    }

}

// 문제:
// 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서,
// 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
//
// 한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
//
// 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록
// 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
//
// 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에,
// 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
//
// N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
