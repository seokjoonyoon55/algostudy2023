import java.util.Scanner;
import java.util.Stack;

public class SWEA_1267_Stack {	
	static int V;
	static int E;
	static int[] indegree;
	static boolean[] visited;
	static boolean[][] adj;
	static Stack<Integer> st;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=1;t<=1;t++) {
			V = sc.nextInt();	// 정점 개수
			E = sc.nextInt();	// 간선 개수
			
			indegree = new int[V];		// 진입차수
			visited = new boolean[V];	// 방문체크
			adj = new boolean[V][V];	// 인접행렬
			
			
			// 인접행렬, 진입차수 저장
			for (int i=0;i<E;i++) {
				int str = sc.nextInt()-1;
				int end = sc.nextInt()-1;
				
				adj[str][end] = true;
				indegree[end]++;
			}
			
			//
			int temp = 0;
			for (int i=0;i<V;i++) {
				if (indegree[i]==0) {
					temp = i;
					break;
				}
			}
			
			//
			DFS(temp);
			
			StringBuilder sb = new StringBuilder();
			
			while (!st.isEmpty()) {
				sb.append((st.pop()+1)+" ");
			}
			
			System.out.printf("#%d %s\n", t,sb);

		}
		
		sc.close();
	}
	
	static void DFS(int v) {
		for (int i=0;i<V;i++) {
			if (!visited[i] && indegree[i]!=0) {
				return;
			}
		}
		
		visited[v] = true;
		
		for (int i=0;i<V;i++) {
			if (adj[v][i] && !visited[i]) {
				DFS(i);
			}
		}
		
		st.add(v);
	}
}
