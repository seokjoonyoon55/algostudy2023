package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Edge>[] edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N + 1];
		int[] minDist = new int[N + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, weight));
		}
		st = new StringTokenizer(br.readLine());
		int dpt = Integer.parseInt(st.nextToken());
		int arv = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(dpt, 0));
		minDist[dpt] = 0;
		while (!pq.isEmpty()) {
			Edge begin = pq.remove();
			int cur = begin.to;
			if (!visited[cur]) {
				visited[cur] = true;
				for (Edge edge : edges[cur]) {
					if (minDist[edge.to] > minDist[cur] + edge.weight) {
						minDist[edge.to] = minDist[cur] + edge.weight;
						pq.add(new Edge(edge.to, minDist[edge.to]));
					}
				}
			}
		}
		System.out.println(minDist[arv]);
	}

	public static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}

	}

}
