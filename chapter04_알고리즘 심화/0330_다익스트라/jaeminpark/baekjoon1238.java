package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<line>[] lines = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			lines[i] = new ArrayList<>();
		}
		int[] timeTaken = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(timeTaken, Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			lines[from].add(new line(to, time));
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(lines[i]);
		}
		PriorityQueue<line> pq = new PriorityQueue<>();

		// 집에 돌아가는 거
		pq.offer(new line(X, 0));
		timeTaken[X] = 0;
		while (!pq.isEmpty()) {
			line l = pq.remove();
			int cur = l.to;
			if (!visited[cur]) {
				visited[cur] = true;
				if (lines[cur] != null) {
					for (int i = 0; i < lines[cur].size(); i++) {
						if (timeTaken[lines[cur].get(i).to] > timeTaken[cur] + lines[cur].get(i).time) {
							timeTaken[lines[cur].get(i).to] = timeTaken[cur] + lines[cur].get(i).time;
							pq.offer(new line(lines[cur].get(i).to, timeTaken[lines[cur].get(i).to]));
						}
					}
				}
			}
		}

		// 파티에 가는거
		for (int i = 1; i <= N; i++) {
			pq.offer(new line(i, 0));
			int[] go = new int[N + 1];
			visited = new boolean[N + 1];
			Arrays.fill(go, Integer.MAX_VALUE);
			go[i] = 0;
			while (!pq.isEmpty()) {
				line Line = pq.remove();
				int cur = Line.to;
				if (!visited[cur]) {
					visited[cur] = true;
					for (line l : lines[cur]) {
						if (go[l.to] > go[cur] + l.time) {
							go[l.to] = go[cur] + l.time;
							pq.offer(new line(l.to, go[l.to]));
						}
					}
				}
			}
			timeTaken[i] += go[X];
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, timeTaken[i]);
		}
		System.out.println(max);
	}

	static class line implements Comparable<line> {
		int to;
		int time;

		line(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(line o) {
			if (time == o.time) {
				return 0;
			}
			return time - o.time;
		}

		@Override
		public String toString() {
			return "line [to=" + to + ", time=" + time + "]";
		}

	}

}
