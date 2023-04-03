package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek5972_택배배송 {
     static class Node implements Comparable<Node>{
    	 int end, w;
    	 
    	 Node(int end, int w){
    		 this.end = end;
    		 this.w = w;
    	 }

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
     }
     static final int INF = Integer.MAX_VALUE;
     static int N, M;
     static List<Node>[] adjList;
     static int[] dist;
     
     public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		dist = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			dist[i] = INF;
			adjList[i] = new ArrayList<>();
		}
		// 양방향 연결
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}
		
		dijkstra(1);
		System.out.println(dist[N]);
     }

	private static void dijkstra(int start) {
		// 우선순위 큐 활용
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		if(start > N) return;
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int end = curr.end;
			int w = curr.w;
			
			if(visited[end]) continue;
			
			visited[end] = true;
			
			for(Node n : adjList[end]) {
				int destEnd = n.end;
				int destW = n.w;
				
				if(dist[destEnd] > dist[end] + destW) {
					dist[destEnd] = dist[end] + destW;
					pq.add(new Node(destEnd, dist[destEnd]));
				}
			}

		}
		
//		for(int i = 1; i <= N; i++) {
//			int min = INF;
//			int idx = -1;
//			
//			for(int j = 1; j <= N; j++) {
//				if(!visited[j] && min > dist[j]) {
//					min = dist[j];
//					idx = j;
//				}
//			}
//			if(idx == -1) break;
//			visited[idx] = true;
//			
//			for(int j = 0; j < adjList[idx].size(); j++) {
//				Node curr = adjList[idx].get(j);
//				
//				if(!visited[curr.end] && dist[curr.end] > dist[idx] + curr.w) {
//					dist[curr.end] = dist[idx] + curr.w;
//				}
//			}
//		}
	}
}