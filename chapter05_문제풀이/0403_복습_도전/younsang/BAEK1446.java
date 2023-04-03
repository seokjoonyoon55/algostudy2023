package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK1446 {
	static int N, D, distance[], INF = Integer.MAX_VALUE;
	static List<Node>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// D가 10,000보다 작거나 같은 자연수이므로 최댓값으로 설정했습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		distance = new int[10001]; 
		graph = new List[10001]; 
		for(int i=0; i<graph.length; i++) {
			distance[i] = i;
			graph[i] = new ArrayList<>(); 
		}
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, d));
		}
		dijkstra(0);

		System.out.println(distance[D]);
	}
	private static void dijkstra(int start) {
		// D값 보다 커지면 메소드 종료
		if(start > D) {
			return;
		}
		// ex) dist[2] 값이 dist[1] + 1 보다 크면 dist[1] + 1로 update
		if(distance[start+1] > distance[start] + 1) {
			distance[start+1] = distance[start] + 1;
		}
		
		// 지름길이 존재하하면 그 길이만큼 반복문 돈다.
		for(int i=0; i<graph[start].size(); i++) {
			// ex) dist[0] + 10 (이거는 값이 0 + 10임) < dist[50] (이거 값이 50임)
			if(distance[start] + graph[start].get(i).value < distance[graph[start].get(i).endPoint]) {
				// 그럼 dist[50]을 update함
				distance[graph[start].get(i).endPoint] = distance[start] + graph[start].get(i).value;
			}
		}
		dijkstra(start+1);
	}
	static class Node {
		int endPoint;
		int value;
		public Node(int endPoint, int value) {
			super();
			this.endPoint = endPoint;
			this.value = value;
		}
	} 
}