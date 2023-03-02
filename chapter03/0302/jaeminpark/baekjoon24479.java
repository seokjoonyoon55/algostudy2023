package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon24479 {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] point;
	static int start;
	static List<Integer>[] lines;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken()) - 1;
		point = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			point[i] = i;
		}
		lines = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			lines[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			if (to != start) {
				lines[from].add(to);
			}
			if (from != start) {
				lines[to].add(from);
			}
		}
		for (int i = 0; i < N; i++) {
			Collections.sort(lines[i]);
		}
		q.offer(start + 1);
		dfs(1, start);
		int[] answer = new int[N];
		int seq = 1;
		while (!q.isEmpty()) {
			answer[q.remove() - 1] = seq++;
		}
		for(int i = 0; i<N; i++) {
			System.out.println(answer[i]);
		}
	}

	static void dfs(int depth, int start) {

		if (depth == N) {
			return;
		}

		for (int i = 0; i < lines[start].size(); i++) {
			if (!visited[lines[start].get(i)]) {
				visited[lines[start].get(i)] = true;
				q.offer(lines[start].get(i) + 1);
				dfs(depth + 1, lines[start].get(i));
			}
		}
	}

}
