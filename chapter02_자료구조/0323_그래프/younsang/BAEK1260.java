package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK1260 {
	static int N,M,V;
	static int[][] graph;
	static boolean[] visit;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] NMV = br.readLine().split(" ");
		N = Integer.parseInt(NMV[0]);
		M = Integer.parseInt(NMV[1]);
		V = Integer.parseInt(NMV[2]);
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A][B] = 1;
			graph[B][A] = 1;
		}
		
		DFS(V);
		System.out.println();
		visit = new boolean[N+1];
		BFS(V);
	}
	
	public static void DFS(int num) {
		System.out.print(num + " ");
		// 방문 처리
		visit[num] = true;
		for (int i = 1; i <= N; i++) {
			// 방문하지 않았고, 노드가 연결돼있으면 재귀 호출
			if(!visit[i] && graph[num][i] == 1) DFS(i);
		}
	}
	
	public static void BFS(int num) {
		System.out.print(num + " ");
		q = new LinkedList<>();
		// 시작 노드 큐에 넣고 방문 처리
		q.add(num);
		visit[num] = true;
		
		// 큐가 빌 때까지
		while(!q.isEmpty()) {
			int temp = q.poll();
			int p = temp;
			for (int i = 1; i <= N; i++) {
				// 방문하지 않았고, 노드가 연결돼있으면 큐에 넣기
				if (graph[p][i] == 1 && !visit[i]) {
					System.out.print(i + " ");
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
}
