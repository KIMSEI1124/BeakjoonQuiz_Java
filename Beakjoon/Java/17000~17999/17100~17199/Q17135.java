import java.io.*;
import java.util.*;

public class Q17135 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int MONSTER = 1;
    private static final List<Monster> monsters = new LinkedList<>();
    private static int answer;

    /* 입력 정보 */
    private static int N, M, D; // N : 세로, M : 가로, D : 궁수의 공격 범위

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 게임 정보 입력 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int monsterId = 1;

        for (int y = 1; y <= N; y++) {
            /* 문자열 입력과 해당 좌표의 리스트 초기화 */
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                int i = Integer.parseInt(st.nextToken());
                if (i == MONSTER) {
                    monsters.add(Monster.of(monsterId++, y, x));
                }
            }
        }
    }

    private static void solve() {
        combination(0, 1, new Archer[3]);
    }

    private static void combination(int cnt, int start, Archer[] archers) {
        /* 3명의 궁수를 배치하면 게임을 시작 */
        if (cnt == 3) {
            defence(archers);
            return;
        }

        for (int i = start; i <= M; i++) {
            archers[cnt] = Archer.of(N + 1, i, D);
            combination(cnt + 1, i + 1, archers);
        }
    }

    private static void defence(Archer[] archers) {
        int killCount = 0;
        List<Monster> tempMonsters = copyMonsters();
        for (int i = 1; i <= N && !tempMonsters.isEmpty(); i++) {
            findDistanceByArcherWithMonster(archers, tempMonsters);
            killCount += killMonster(archers, tempMonsters);
            moveMonsters(tempMonsters);
        }
        answer = Math.max(killCount, answer);
    }

    private static List<Monster> copyMonsters() {
        List<Monster> temp = new LinkedList<>();
        for (Monster monster : monsters) {
            temp.add(monster.copy());
        }
        return temp;
    }

    private static void moveMonsters(List<Monster> tempMonsters) {
        Set<Monster> removeMonsters = new HashSet<>();
        for (Monster monster : tempMonsters) {
            int y = monster.move();
            /* 성에 도달하면 삭제 */
            if (y > N) {
                removeMonsters.add(monster);
            }
        }

        for (Monster monster : removeMonsters) {
            tempMonsters.remove(monster);
        }
    }

    private static void findDistanceByArcherWithMonster(Archer[] archers, List<Monster> tempMonsters) {
        for (Archer archer : archers) {
            for (Monster monster : tempMonsters) {
                monster.getDistanceArcher(archer);
            }
        }
    }

    private static int killMonster(Archer[] archers, List<Monster> tempMonsters) {
        Set<Monster> deadMonsters = new HashSet<>();
        for (Archer archer : archers) {
            Monster deadMonster = archer.killMonster();
            if (deadMonster != null) {
                deadMonsters.add(deadMonster);
            }
        }

        for (Monster deadMonster : deadMonsters) {
            tempMonsters.remove(deadMonster);
        }

        return deadMonsters.size();
    }

    private static class Monster {
        private final int id;
        private final int x;
        private int y;

        private Monster(int id, int y, int x) {
            this.id = id;
            this.y = y;
            this.x = x;
        }

        public static Monster of(int id, int y, int x) {
            return new Monster(id, y, x);
        }

        /* 몬스터가 이동한다 */
        public int move() {
            y++;

            return y;
        }

        /* 궁수와 몬스터 사이의 거리 구하기 */
        public void getDistanceArcher(Archer archer) {
            /* 이미 삭제된 몬스터면 거리를 구하지 않는다. */
            int distance = getDistance(archer);

            /* 만약 궁수의 사정거리 안에 들어온다면 제거 목록에 넣기 */
            if (archer.getRange() >= distance) {
                archer.addKillTargetByMonster(this);
            }
        }

        public int getDistance(Archer archer) {
            return Math.abs(y - archer.getY()) + Math.abs(x - archer.getX());
        }

        public int getX() {
            return x;
        }

        public Monster copy() {
            return of(id, y, x);
        }
    }

    private static class Archer {
        private final int y;
        private final int x;
        private final int range; // 궁수의 사정거리
        private Monster targetMonster; // `kill`할 몬스터

        public Archer(int y, int x, int range) {
            this.y = y;
            this.x = x;
            this.range = range;
        }

        public static Archer of(int y, int x, int range) {
            return new Archer(y, x, range);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getRange() {
            return range;
        }

        public void addKillTargetByMonster(Monster monster) {
            /* `kill`할 몬스터가 없을 경우 */
            if (targetMonster == null) {
                targetMonster = monster;
                return;
            }

            int newMonsterDistance = monster.getDistance(this);
            int nowMonsterDistance = targetMonster.getDistance(this);

            /* 새로운 `target`의 거리가 더 가까울 경우 */
            if (newMonsterDistance < nowMonsterDistance) {
                targetMonster = monster;
                return;
            }

            /* 새로운 `target`의 거리가 같고 더 왼쪽에 있을 경우 */
            if (newMonsterDistance == nowMonsterDistance && monster.getX() < targetMonster.getX()) {
                targetMonster = monster;
            }
        }

        /**
         * 몬스터를 `Kill` 한다.
         */
        public Monster killMonster() {
            /* 만약 `Kill` 할 몬스터가 없다면 종료 */
            if (targetMonster == null) {
                return null;
            }

            /* 1순위 몬스터를 죽이고 난 턴 종료를 위해 초기화 */
            Monster temp = targetMonster;
            targetMonster = null;
            return temp;
        }
    }
}
