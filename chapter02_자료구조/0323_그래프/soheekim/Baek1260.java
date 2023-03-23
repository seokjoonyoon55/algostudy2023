package study0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek1260 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;

	static boolean[] visitDFS;// DFS 방문 표시
	static boolean[] visitBFS;// BFS 방문 표시

	static List<Integer>[] linked;// 간선 정보 저장

	static Queue<Integer> quu = new LinkedList<>();// BFS에 사용할 큐

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		// NMV입력 받기
		String[] NMV = bfr.readLine().split(" ");
		N = Integer.parseInt(NMV[0]);// 노드 갯수
		M = Integer.parseInt(NMV[1]);// 간선 갯수
		V = Integer.parseInt(NMV[2]);// 시작 노드 인덱스

		linked = new ArrayList[N + 1];// 연결 리스트. 0번 인덱스 사용안함

		visitDFS = new boolean[N + 1];// DFS 방문 표시
		visitBFS = new boolean[N + 1];// BFS 방문 표시

		// 연결리스트 내부에 선언
		for (int i = 1; i < N + 1; i++) {
			linked[i] = new ArrayList<Integer>();
		}

		// 간선 입력
		for (int i = 0; i < M; i++) {
			String[] temp = bfr.readLine().split(" ");
			int node1 = Integer.parseInt(temp[0]);
			int node2 = Integer.parseInt(temp[1]);
			linked[node1].add(node2);
			linked[node2].add(node1);
		}

		// 연결된 노드들 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(linked[i]);
		}

		DFS(V, 0);

		sb.append("\n");

		BFS(V);

		System.out.println(sb);

	}

	// 깊이 우선 탐색
	public static void DFS(int node, int depth) {

		// 탐색 완료하면 종료
		if (depth == N + 1)
			return;

		// 시작할 때 시작점 방문표시
		if (depth == 0) {
			visitDFS[node] = true;
			sb.append(node);
		}

		int curr = -1;// 임시변수

		// node에 연결된 것들에 대해
		for (int i = 0; i < linked[node].size(); i++) {
			curr = linked[node].get(i);

			// 방문된 적 있으면 다음
			if (visitDFS[curr])
				continue;

			// 방문 표시
			visitDFS[curr] = true;
			sb.append(" ").append(curr);

			// 다음 노드에 대해 DFS
			DFS(curr, depth + 1);
		}
	}

	// 너비 우선 탐색
	public static void BFS(int start) {

		// 임시변수들
		int curr = -1;
		int temp = -1;

		// 시작점 방문 표시 후 큐에 추가
		visitBFS[start] = true;
		sb.append(start);
		quu.add(start);

		// 큐가 비어있지 않는 동안
		while (!quu.isEmpty()) {
			curr = quu.poll();

			// 현재노드에 연결된 것들에 대해
			for (int i = 0; i < linked[curr].size(); i++) {
				temp = linked[curr].get(i);

				// 방문된 적이 없으면
				if (!visitBFS[temp]) {
					// 방문 표시하고 큐에 넣음
					visitBFS[temp] = true;
					sb.append(" ").append(temp);
					quu.add(temp);
				}
			}
		}

	}

}
