import java.util.*;
import java.io.*;

public class Q11060 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int answer;

	private static int N;
	private static int[] arr;
	private static int[] visited;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(answer);
	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void solve() {
		Deque<Person> queue = new ArrayDeque<>();
		queue.add(new Person(1, 0));
		while (!queue.isEmpty()) {
			Person person = queue.poll();
			int index = person.getIndex();
			if (index == N) {
				answer = person.getCount();
				return;
			}
			int nextCount = person.getCount() + 1;
			for (int i = 1; i <= arr[index]; i++) {
				int nextIndex = index + i;
				if (nextIndex > N || (visited[nextIndex] != 0 && nextIndex >= visited[nextIndex])) {
					continue;
				}
				visited[nextIndex] = nextCount;
				queue.add(new Person(nextIndex, nextCount));
			}
		}
		answer = -1;
	}

	private static class Person {
		private final int index;
		private final int count;

		public Person(int index, int count) {
			this.index = index;
			this.count = count;
		}

		public int getIndex() {
			return index;
		}

		public int getCount() {
			return count;
		}

		@Override
		public String toString() {
			return String.format("{index : %d, count : %d}", index, count);
		}
	}
}
