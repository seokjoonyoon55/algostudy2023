package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek5567 {
	static int n;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 친구 관계 저장할 리스트 배열
		List<Integer> list[] = new ArrayList[n + 1];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 친구 관계 연결
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		// 방문여부 확인할 배열
		visited = new boolean[n + 1];
		// 상근이 학번이 1번이니까 true로 만들어주기
		visited[1] = true;
		
		dfs(1, list, 0);
		
		// 상근이 학번이 1번이니까 배열 인덱스 2번부터 방문체크배열 확인하기
		int result = 0;
		for(int i = 2; i < visited.length; i++) {
			if(visited[i]) result++;
		}
		System.out.println(result);
	}
	
	private static void dfs(int n, List<Integer>[] list, int depth) {
		// base case
		// 상근이의 친구와 친구의 친구까지만 확인
		if(depth == 2) return;
		
		// recursive case
		// 해당 학번의 친구들 수만큼 반복문 돌리기
		// 해당 학번의 친구들한테 방문 시 방문체크하기
		for(int i = 0; i < list[n].size(); i++) {
			int next = list[n].get(i);
			visited[next] = true;
			dfs(next, list, depth + 1);
		}
		
	}
}
