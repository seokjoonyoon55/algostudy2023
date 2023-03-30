package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK1389 {
	static int N,M,level,bacon,who;
	static boolean[] visit;
	static int[][] graph;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 무방향 그래프
			graph[A][B] = 1;
			graph[B][A] = 1;
		}
		int min = Integer.MAX_VALUE;
		who = 0;
		q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			// 각 행 반복문 시작될 때마다 방문 배열 초기화
			visit = new boolean[N+1];
			// 해당 행 방문 true로 초기화
			visit[i] = true;
			// 1단계
			level = 1;
			// 총 Bacon의 수 냠냠
			bacon = 0;
			
			// 각 열 반복문 돌 때
			// 방문하지 않았고 연결돼있으면 큐에 넣는다.
			for (int j = 1; j <= N; j++) {
				if (!visit[j] && graph[i][j] == 1) {
					q.add(new int[] {j,level});	
				}
			}
			
			// 큐가 빌 때 까지 poll
			// 큐에서 뺀 값이 연결돼있는? 행
			// 그 곳을 방문하지 않았다면 bacon에 level을 더해준다
			// 방문하지 않았고, 연결돼있으면 다시 큐에 넣어준다.
			while(!q.isEmpty()) {
				int[] ele = q.poll();
				if (!visit[ele[0]]) bacon += ele[1];
				visit[ele[0]] = true;
				for (int k = 1; k <= N; k++) {
					if (!visit[k] && graph[ele[0]][k] == 1) {
						q.add(new int[] {k, ele[1]+1});
					}
				}
			}
			
			// min 값이 bacon보다 크면
			// bacon 갱신과 동시에 사람도 갱신!!!
			if (min > bacon) {
				min = bacon;
				who = i;
			}
		}
		System.out.println(who);
	}
}
