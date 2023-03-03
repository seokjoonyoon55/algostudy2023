package barkingdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24479_깊이우선탐색 {
	static int N, M, R;
	static ArrayList<Integer>[] list;
	static StringBuilder sb;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(R);
		System.out.println(sb);
	}
	// 시작 정점에서 방문할 수 없는 경우 0 출력..
	// 어떻게 하나 ? ㅠㅠ
	public static void dfs(int Node) {
		sb.append(Node).append("\n");
		visited[Node] = true;
		for(int i : list[Node]) {
			if(!visited[i]) dfs(i);
		}
	}
}
