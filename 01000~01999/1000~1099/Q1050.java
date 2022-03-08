import java.io.*;
import java.util.*;

public class Q1050 { // 5,8오류
    public static void main(String[] args) throws IOException {
        int answer = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 재료의 개수
        int M = Integer.parseInt(st.nextToken()); // 물약 제조식의 개수
        HashMap<String, Integer> hash = new HashMap<>(); // 재료 저장
        String[][] key = new String[M][]; // 물약과 재료의 이름
        int[][] value = new int[M][]; // 물약과 재료의 개수
        long[][] cost = new long[M][]; // 물약과 재료의 값 , 예제 6의 오류로 long타입으로 변경함
        while (N > 0) { // 재료 저장
            st = new StringTokenizer(br.readLine());
            hash.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            N--;
        }
        for (int i = 0; i < M; i++) { // ex ) LOVE=2WATER+4HONEY+2BEER
            // ex ) 1) LOVE, 2) 2WATER+4HONEY+2BEER
            st = new StringTokenizer(br.readLine(), "=", false);
            String potion = st.nextToken();
            // ex ) 1) 2WATER, 2) 4HONEY, 3) 2BEER
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+", false);
            int count = st2.countTokens(); // 물약 제조에 필요한 재료의 종류 수
            for (int j = 0; j < count + 1; j++) {
                if (j == 0) {
                    key[i] = new String[count + 1];
                    value[i] = new int[count + 1];
                    cost[i] = new long[count + 1];
                    key[i][j] = potion; // ex ) LOVE
                } else {
                    String str = st2.nextToken(); // ex ) 2WATER
                    key[i][j] = str.substring(1); // ex ) WATER
                    value[i][j] = Integer.parseInt(str.substring(0, 1)); // ex ) 2
                }
            }
        }
        for (int i = 0; i < key.length; i++) {
            if (cost[i][0] == 0) {
                hash = potion(key, value, cost, hash, i);
            }
        }
        if (hash.containsKey("LOVE")) { // LOVE를 제조할수 있으면
            answer = hash.get("LOVE");
        }
        System.out.println(hash);
        System.out.println(answer);
    }

    public static HashMap<String, Integer> potion(String[][] key, int[][] value, long[][] cost,
            HashMap<String, Integer> hash,
            int i) {
        int money = 0;
        for (int j = 1; j < key[i].length; j++) {
            if (key[i][j].equals("LOVE")) { // 1. 제조할 수 없을 경우
                cost[i][0] = 0;
                break;
            } else if (hash.containsKey(key[i][j])) { // 2. 상점에서만 파는 물건이거나 이미 조합된 물약을 사용할 경우
                cost[i][j] = hash.get(key[i][j]) * value[i][j] * 1L;
            } else { // 3. 물약을 조합해서 사용해야할 경우
                for (int k = i + 1; k < key.length; k++) {
                    if (key[i][j].equals(key[k][0])) { // 3.1 필요한 물약의 제조법이 있을경우
                        // 오류 발생!!!!!!! 1을 제작할때 2가 필요함, 2를 제작할때 1이 필요함, 무한 루프 예제 5번
                        hash = potion(key, value, cost, hash, k);
                        cost[i][j] = hash.get(key[i][j]) * value[i][j] * 1L;
                    } else if (k == key.length - 1) { // 3.2 필요한 물약의 제조법이 없을경우
                        break;
                    }
                }
            }
            cost[i][0] += cost[i][j] * 1L;
            if (cost[i][0] * 1L > 1000000000) { // 예제 6번 오류
                money = 1000000001;
                break;
            }
        }
        if (money != 1000000001 && cost[i][0] != 0) {
            money = (int) cost[i][0];
        }
        System.out.println(hash);
        if (money != 0) {
            if (hash.containsKey(key[i][0])) { // 1. hash에 이미 동일한 key가 있을경우
                hash.replace(key[i][0], Math.min(hash.get(key[i][0]), money)); // 비교해서 적은 값으로 바꾼다.
            } else { // 2. hash에 동일한 key가 없을 경우
                hash.put(key[i][0], money);
            }
        }
        return hash;
    }
}