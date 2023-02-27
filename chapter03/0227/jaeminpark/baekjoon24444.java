package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon24444 {

	// 정점 개수
	static int N;
	// 간선 개수
	static int M;
	// 시작 정점
	static int start;
	// 방문 여부 저장 배열
	static boolean visited[];
	// 큐
	static Queue<Integer> q = new ArrayDeque<>();
	// 각 정점에서 이어지는 간선 저장 리스트
	static List<Integer>[] lines;
	static StringBuilder sb = new StringBuilder();
	// 최종 답안
	static int[] answer;
	// 순서
	static int seq = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken()) - 1;
		lines = new ArrayList[N];
		visited = new boolean[N];
		answer = new int[N];
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
		// 오름차순 정렬
		for (int i = 0; i < N; i++) {
			Collections.sort(lines[i]);
		}
		
		// bfs 시작
		bfs(start);

		for(int i = 0; i<N; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);

	}

	static void bfs(int start) {
		// 일단 큐(대기열)에 넣어주고
		q.offer(start);
		// start를 방문했다고 표시
		visited[start] = true;
		// 방문한거니까 start의 answer안에서의 위치에 순서(seq)넣고 seq추가(다음 순서는 2이니까)
		answer[start] = seq++;
		
		while (!q.isEmpty()) {
			// k = 대기열에서 뽑힌 순서(너비 우선)
			int k = q.remove();
			// k의 간선에 대해 
			for (int i = 0; i < lines[k].size(); i++) {
				// k에서 갈 수 있는 다음 정점
				int x = lines[k].get(i);
				// 그 정점에 간 적이 없다면
				if (!visited[x]) {
					// 그 정점 방문해야 되므로 간거 표시하고
					visited[x] = true;
					// 대기열에 그 정점 넣음 순서대로 넣으면 k의 다음 정점도 차례대로 들어감
					q.offer(x);
					// answer의 x에 해당하는 위치에 순서넣기
					answer[x] = seq++;
				}
			}
		}
	}

}
