package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11403 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		List<Integer>[] lines = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			lines[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			int from = i;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					int to = j; // 불필요하긴 함 => 그냥 from -> to 나 편하려고 변수 선언
					lines[from].add(to);
				}
			}
		}
		// 출력할 배열
		int[][] answer = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// bfs 돌릴 큐
				Queue<Integer> q = new ArrayDeque<>();
				q.offer(i);
				boolean canGo = false;
				boolean[] visited = new boolean[N];
				loop: while (!q.isEmpty()) {
					int I = q.remove();
					visited[I] = true;
					for (int k = 0; k < lines[I].size(); k++) {
						int nI = lines[I].get(k);
						if (nI == j) {
							canGo = true;
							break loop;
						}
						if (!visited[nI]) {
							visited[nI] = true;
							q.offer(nI);
						}
					}
				}
				// 해당 좌표에 갈 수 있으면 1 저장
				if (canGo) {
					answer[i][j] = 1;
				}
			}
		}
		// 출력 형식
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
