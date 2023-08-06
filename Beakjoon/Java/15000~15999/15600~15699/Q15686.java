import java.io.*;
import java.util.*;

public class Q15686 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int HOME = 1; // 집
    private static final int STORE = 2; // 가게

    private static int answer = Integer.MAX_VALUE;
    private static StringTokenizer st;

    /* Input Value */
    private static int n, m; // 지도의 크기, 치킨 집의 최대 개수
    private static List<Pos> homes = new ArrayList<>(); // 집의 좌표
    private static List<Pos> stores = new ArrayList<>(); // 가게의 좌표
    private static int[][] distance; // 집과 가게의 거리 저장

    public static void main(String[] args) throws IOException {
        input();
        solve();
        minStoreDistance(0, new HashSet<>());
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                int cityInfo = Integer.parseInt(st.nextToken()); // 도시의 정보
                if (cityInfo == HOME) {
                    homes.add(Pos.of(y, x));
                    continue;
                }
                if (cityInfo == STORE) {
                    stores.add(Pos.of(y, x));
                }
            }
        }
    }

    private static void solve() {
        getDistances();
    }

    private static void getDistances() {
        distance = new int[stores.size()][homes.size()]; // 집과 가게의 거리 저장 배열 초기화
        for (int storeIdx = 0; storeIdx < stores.size(); storeIdx++) {
            for (int homeIdx = 0; homeIdx < homes.size(); homeIdx++) {
                distance[storeIdx][homeIdx] = getDistance(stores.get(storeIdx), homes.get(homeIdx));
            }
        }
    }

    private static int getDistance(Pos store, Pos home) {
        return Math.abs(store.getY() - home.getY()) + Math.abs(store.getX() - home.getX());
    }

    private static void minStoreDistance(int idx, Set<Integer> storeIdx) {
        if (storeIdx.size() > m) {
            return;
        }

        if (storeIdx.size() == m) {
            answer = Math.min(answer, getStoreDistance(storeIdx));
        }

        for (int i = idx; i < stores.size(); i++) {
            if (!storeIdx.contains(i)) {
                storeIdx.add(i);
                minStoreDistance(i + 1, storeIdx);
                storeIdx.remove(i);
            }
        }
    }

    private static int getStoreDistance(Set<Integer> idx) {
        int storeDistance = 0;
        for (int x = 0; x < homes.size(); x++) {
            int min = Integer.MAX_VALUE;
            for (Integer y : idx) {
                min = Math.min(min, distance[y][x]);
            }
            storeDistance += min;
        }
        return storeDistance;
    }

    private static class Pos {
        private int y;
        private int x;

        private Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public static Pos of(int y, int x) {
            return new Pos(y, x);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}