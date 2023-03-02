package barkingdog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs01 {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		
		// 연결된 두 정점 번호 오름차순 정렬
		for(int i = 1; i <= n; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(v);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(v);
	}
	
	// 방문 -> true -> 해당 칸의 인접칸 방문
	// -> 다음 방문할 노드 값으로 바꾸어 재실행
	public static void dfs(int Node) {
		System.out.print(Node + " ");
		visited[Node] = true;
		for(int i : list[Node]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	// 탐색 시작할 정점의 번호부터
	// 큐에 추가 -> 방문체크 -> 큐에서 빼면서 출력 -> 해당 정점에 인접한 배열 탐색
	// 방문을 안했던 곳이라면 true로 변경 -> 큐에 추가
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int Node = queue.poll();
			System.out.print(Node + " ");
			for(int i : list[Node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
