package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11724 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] lines = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			lines[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			lines[from].add(to);
			lines[to].add(from);
		}

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				cnt++;
				q.offer(i);
				while (!q.isEmpty()) {
					int x = q.remove();
					visited[x] = true;
					for (int j = 0; j < lines[x].size(); j++) {
						if (!visited[lines[x].get(j)]) {
							visited[lines[x].get(j)] = true;
							q.offer(lines[x].get(j));
						}
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
