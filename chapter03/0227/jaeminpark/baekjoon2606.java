package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2606 {

	static int N;
	static int M;
	static int cnt = 0;
	static boolean[] visited;
	static Queue<Integer> q = new ArrayDeque<>();
	static List<Integer>[] lines;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		lines = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			lines[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			lines[from].add(to);
			lines[to].add(from);
		}
//		System.out.println(Arrays.toString(lines));
		bfs(0);
		System.out.println(cnt);
	}

	static void bfs(int start) {
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int k = q.remove();
			for (int i = 0; i < lines[k].size(); i++) {
				int x = lines[k].get(i);
				if (!visited[x]) {
					visited[x] = true;
					cnt++;
					q.offer(x);
				}
			}
		}

	}

}
