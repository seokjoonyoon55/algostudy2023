package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK2606 {
	static int N, M;
	static int[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		// 방문 리스트 선언
		visited = new int[N+1];
		
		// N개 만큼 리스트 안에 리스트 할당?
		for(int i = 0; i<=N; i++)
            list.add(new ArrayList<>());
		
		// x와  연결된 y 컴퓨터 삽입
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		// 1번 컴퓨터와 연결되어진 모든 컴퓨터 탐색
		bfs(1);
	}
	
	public static void bfs(int R) {
		// 큐 선언
		Queue<Integer> q = new LinkedList<>();
		
		// 카운트 변수 선언 및 초기화
		int cnt = 1;
		
		// 방문 리스트에 카운트 변수 할당
		visited[R] = cnt++;
		// 큐에 삽입
		q.add(R);
		while(!q.isEmpty()) {
			int element = q.poll();
			for (int i = 0; i < list.get(element).size(); i++) {
				int next = list.get(element).get(i);
				
				// 0이 아니면 방문했으므로 continue
				if (visited[next] != 0)
					continue;
				
				// 방문 안한 곳 큐에 삽입
				q.add(next);
				// 방문 처리
				visited[next] = cnt++;
			}
		}
		int max = 0;
		// 방문할 때마다 cnt++ 이므로 제일 큰 값 탐색
		for (int i = 0; i < visited.length; i++) {
			max = (max < visited[i]) ? visited[i] : max;
		}
		
		// 초기값을  1로 설정했으므로 max - 1 값 출력
		System.out.println(max-1);
	}
}
