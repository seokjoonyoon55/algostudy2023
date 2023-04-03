import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1267_Queue {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=1;t<=10;t++) {
			int V = sc.nextInt();	// 정점 개수
			int E = sc.nextInt();	// 간선 개수
			
			int[] indegree = new int[V];	// 진입차수
			boolean[][] adj = new boolean[V][V];	// 인접행렬
			
			// 인접행렬, 진입차수 저장
			for (int i=0;i<E;i++) {
				int str = sc.nextInt()-1;
				int end = sc.nextInt()-1;
				
				adj[str][end] = true;
				indegree[end]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			// 큐에 진입차수 0인 정점 집어넣기
			for (int i=0;i<V;i++) {
				if (indegree[i]==0) {
					q.add(i);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			// 진입차수가 0인 정점을 큐에 넣고 빼면서 큐가 빌 때까지 반복
			while (!q.isEmpty()) {
				// 큐에서 하나 꺼내서 출력값에 넣어줌
				int temp = q.poll();
				sb.append((temp+1)+" ");
				
				// 큐에서 꺼낸 정점을 출발하여 도착하는 정점의 진입차수 --
				// 만약 1 빼준 진입차수가 0이라면 큐에 넣어줌
				for (int i=0;i<V;i++) {
					if (adj[temp][i]) {
						indegree[i]--;
						
						if (indegree[i]==0) {
							q.add(i);
						}
					}
				}
			}
			
			System.out.printf("#%d %s\n", t,sb);
		}
		
		sc.close();
	}
}
