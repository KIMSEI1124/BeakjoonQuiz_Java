package LEVEL3;

import java.util.*;

/**
 * 문제 풀이 : Map과 PriorityQueue를 사용하여 풀었습니다.
 * 시간: 2.04ms
 * 메모리:  87.5MB
 */
class 베스트앨범 {

    private List<Integer> answer;
    private Map<String, Genre> map;
    private PriorityQueue<Genre> genrePQ;

    public List<Integer> solution(String[] genres, int[] plays) {
        init(genres, plays);
        solve();
        return answer;
    }

    private void init(String[] genres, int[] plays) {
        map = new HashMap<>();
        int length = genres.length;

        for (int i = 0; i < length; i++) {
            String key = genres[i];
            if (!map.containsKey(key)) {
                map.put(key, new Genre());
            }
            map.get(key).offer(new Music(i, plays[i]));
        }

        genrePQ = new PriorityQueue<>();
    }

    private void solve() {
        for (Genre genre : map.values()) {
            genrePQ.offer(genre);
        }

        answer = new ArrayList<>();

        while (!genrePQ.isEmpty()) {
            int count = 0;
            Genre genre = genrePQ.poll();
            while (!genre.isEmpty() && count < 2) {
                Music music = genre.poll();
                answer.add(music.getId());
                count++;
            }
        }
    }

    private static class Genre implements Comparable<Genre> {
        private final PriorityQueue<Music> pq;
        private int totalPlays;

        public Genre() {
            pq = new PriorityQueue<>();
        }

        public void offer(Music music) {
            pq.offer(music);
            totalPlays += music.getPlays();
        }

        public boolean isEmpty() {
            return pq.isEmpty();
        }

        public Music poll() {
            return pq.poll();
        }

        public int getTotalPlays() {
            return totalPlays;
        }

        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.getTotalPlays(), totalPlays);
        }
    }

    private static class Music implements Comparable<Music> {
        private final int id;
        private final int plays;

        public Music(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }

        public int getId() {
            return id;
        }

        public int getPlays() {
            return plays;
        }

        @Override
        public int compareTo(Music o) {
            return Integer.compare(o.plays, plays);
        }
    }
}
