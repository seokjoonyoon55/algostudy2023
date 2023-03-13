package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 정점 개수
		int N = Integer.parseInt(br.readLine());
		// 간선들
		List<Integer>[] lines = new ArrayList[N + 1];
		// 간선들 초기화
		for (int i = 0; i <= N; i++) {
			lines[i] = new ArrayList<>();
		}
		// 간선들 정보 넣기
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			lines[from].add(to);
			lines[to].add(from);
		}
		// 부모 집합(각각의 인덱스의 부모들이 인덱스의 값임)
		int[] parents = new int[N + 1];
		// 방문 여부 판단할 배열
		boolean[] visited = new boolean[N + 1];
		// 루트는 1이랬음
		int root = 1;
		// 루트는 방문 표시
		visited[root] = true;
		// bfs? 돌릴 큐
		Queue<Integer> q = new LinkedList<>();
		// 큐에 루트 넣기
		q.offer(root);
		while (!q.isEmpty()) {
			int parent = q.remove();
			visited[parent] = true;
			for (int i = 0; i < lines[parent].size(); i++) {
				if (!visited[lines[parent].get(i)]) {
					visited[lines[parent].get(i)] = true;
					// parent의 자식들 인덱스에 parent값 넣어주기
					parents[lines[parent].get(i)] = parent;
					q.offer(lines[parent].get(i));
				}
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
	}

}
