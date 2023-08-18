package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 무선_충전 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int[] moveA;
    private static int[] moveB;
    private static User userA;
    private static User userB;
    private static Station[] stations;
    private static int time;
    private static int stationCount;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(userA.getScore() + userB.getScore()).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 테스트 케이스의 정보 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        stationCount = Integer.parseInt(st.nextToken());

        /* 유저 정보 초기화 */
        userA = User.of(1, 1);
        userB = User.of(10, 10);

        /* 이동 정보 초기화 */
        moveA = new int[time];
        moveB = new int[time];

        /* 이동 정보 저장 */
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < time; i++) {
            moveA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < time; i++) {
            moveB[i] = Integer.parseInt(st.nextToken());
        }

        stations = new Station[stationCount];
        for (int i = 0; i < stationCount; i++) {
            st = new StringTokenizer(br.readLine());
            stations[i] = Station.of(i, st);
        }
    }

    private static void solve() {
        for (int i = 0; i <= time; i++) {
            /* 사용자와 충전소의 거리를 구하기 */
            getUserDistanceByStation();

            /* 충전하기 */
            charging();

            /* 시간이 되었으면 충전하고 이동하지 않고 종료 */
            if (i == time) {
                break;
            }

            /* 사용자 이동 하기 */
            moveUsers(i);
        }
    }

    private static void moveUsers(int i) {
        userA.move(moveA[i]);
        userB.move(moveB[i]);
    }

    private static void charging() {
        /* A 충전소 확인하기 */
        Station[] aStation = getStations(userA);
        /* B 충전소 확인하기 */
        Station[] bStation = getStations(userB);

        /* 아무 충전소도 존재하지 않을 때 */
        if (aStation[0] == null && bStation[0] == null) {
            return;
        }

        /* 사용자 B만 충전소에 있을 때 */
        if (aStation[0] == null) {
            userB.addScore(bStation[0].getValue());
            return;
        }

        /* 사용자 A만 충전소에 있을 때 */
        if (bStation[0] == null) {
            userA.addScore(aStation[0].getValue());
            return;
        }

        /* 두명이 같이 있는 충전소가 다른 경우 */
        if (aStation[0].getId() != bStation[0].getId()) {
            userA.addScore(aStation[0].getValue());
            userB.addScore(bStation[0].getValue());
            return;
        }

        /* 두명이 있는 충전소가 같은 경우 */
        /* A와 B의 충전소가 1개씩 있을 때 */
        if (aStation[1] == null && bStation[1] == null) {
            userA.addScore(aStation[0].getValue() / 2);
            userB.addScore(bStation[0].getValue() / 2);
            return;
        }
        /* A는 2개의 충전소가 있고 B는 1개만 있을 때 */
        if (bStation[1] == null) {
            userA.addScore(aStation[1].getValue());
            userB.addScore(bStation[0].getValue());
            return;
        }

        /* A는 1개의 충전소가 있고 B는 2개 있을 때 */
        if (aStation[1] == null) {
            userA.addScore(aStation[0].getValue());
            userB.addScore(bStation[1].getValue());
            return;
        }

        /* A와 B가 2개씩 의 충전소가 있을 때  */
        if (aStation[1].getId() != bStation[1].getId() &&
                aStation[0].getValue() / 2 > bStation[1].getValue() && bStation[0].getValue() / 2 > aStation[1].getValue()) {
            userA.addScore(aStation[0].getValue() / 2);
            userB.addScore(bStation[0].getValue() / 2);
            return;
        }

        /* A 의 값이 더 큰 경우 */
        if (aStation[1].getValue() > bStation[1].getValue()) {
            userA.addScore(aStation[1].getValue());
            userB.addScore(bStation[0].getValue());
            return;
        }

        /* 그 외 (B의 값이 더 크거나 같은 경우 )*/
        userA.addScore(aStation[0].getValue());
        userB.addScore(bStation[1].getValue());
    }

    private static Station[] getStations(User user) {
        Set<Integer> tempSet = user.getStations();
        Station[] temp = new Station[2];
        for (Integer stationId : tempSet) {
            Station station = stations[stationId];
            /* 비어 있지 않은 경우에 */
            if (temp[0] != null) {
                /* 해당 스테이션이 가장 크다면 */
                if (station.getValue() > temp[0].getValue()) {
                    temp[1] = temp[0];
                    temp[0] = station;
                    continue;
                }

                /* 해당 스테이션의 값이 없다면 */
                if (temp[1] == null) {
                    temp[1] = station;
                    continue;
                }

                /* 해당 스테이션의 값이 두번째로 크다면 */
                if (station.getValue() > temp[1].getValue()) {
                    temp[1] = station;
                }
                continue;
            }
            temp[0] = station;
        }
        return temp;
    }

    private static void getUserDistanceByStation() {
        for (int i = 0; i < stationCount; i++) {
            Station station = stations[i];
            userA.updateStation(station);
            userB.updateStation(station);
        }
    }


    private static class Station {
        private final int id;
        private final int y;
        private final int x;
        private final int value;
        private final int range;

        private Station(int id, int y, int x, int value, int range) {
            this.id = id;
            this.y = y;
            this.x = x;
            this.value = value;
            this.range = range;
        }

        public static Station of(int id, StringTokenizer st) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int range = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            return new Station(id, y, x, value, range);
        }

        public int getId() {
            return id;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getValue() {
            return value;
        }

        public int getRange() {
            return range;
        }

        @Override
        public String toString() {
            return "Station{" +
                    "id=" + id +
                    ", y=" + y +
                    ", x=" + x +
                    ", value=" + value +
                    ", range=" + range +
                    '}';
        }
    }

    private static class User {
        private final Set<Integer> stations;
        private int y;
        private int x;
        private int score;

        private User(int y, int x) {
            this.y = y;
            this.x = x;
            this.stations = new HashSet<>();
        }

        public static User of(int y, int x) {
            return new User(y, x);
        }

        public void move(int code) {
            if (code == 1) { // 상
                y--;
            } else if (code == 2) {    // 우
                x++;
            } else if (code == 3) {    // 하
                y++;
            } else if (code == 4) {    // 좌
                x--;
            }
        }

        public void updateStation(Station station) {
            /* 충전소와 사용자의 거리를 구하기 */
            int distance = Math.abs(station.getY() - y) + Math.abs(station.getX() - x);

            /* 충전소 안에 있으면 */
            if (station.getRange() >= distance) {
                stations.add(station.getId());
                return;
            }

            /* 충전소 밖에 있으면 */
            stations.remove(station.getId());
        }

        public int getScore() {
            return score;
        }

        public Set<Integer> getStations() {
            return stations;
        }

        public void addScore(int score) {
            this.score += score;
        }
    }
}
