package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon5972 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean visited[] = new boolean[N + 1];
		List<line>[] lines = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			lines[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			lines[from].add(new line(to, cost));
			lines[to].add(new line(from, cost));
		}
		PriorityQueue<line> pq = new PriorityQueue<>();
		int[] minCost = new int[N + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		pq.offer(new line(1, 0));
		minCost[1] = 0;
		while (!pq.isEmpty()) {
			line L = pq.remove();
			int cur = L.to;
			if (visited[cur])
				continue;
			visited[cur] = true;
			for (line l : lines[cur]) {
				if (minCost[l.to] > minCost[cur] + l.cost) {
					minCost[l.to] = minCost[cur] + l.cost;
					pq.offer(new line(l.to, minCost[l.to]));
				}
			}
		}
		System.out.println(minCost[N]);
	}

	static class line implements Comparable<line> {
		int to;
		int cost;

		line(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(line o) {
			return cost - o.cost;
		}
	}

}
