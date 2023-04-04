package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1516_게임개발 {
	static int N;
	static int[] time, in_degree, ans;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		in_degree = new int[N + 1];
		time = new int[N + 1];
		ans = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			// 입력값이 남아있을 때까지 반복
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				// 먼저 지어져야하는 건물에 연결해주기
				list[num].add(i);
				// 연결해준 건물의 진입차수 배열 값 증가
				in_degree[i]++;
			}
		}
		TopologicalSort();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
	static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		// 진입차수 배열의 값이 0이면 큐에 넣기
		for(int i = 1; i <= N; i++) {
			if(in_degree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int v = q.remove(); // 큐에서 숫자 하나 꺼내서
			ans[v] += time[v]; // 걸린 시간 더해주기
			
			// v 건물 다음에 지어야하는 건물들의 개수만큼 반복
			for(int i = 0; i < list[v].size(); i++) {
				int next = list[v].get(i);
				
				in_degree[next]--; // 해당 건물 진입차수배열 --
				if(in_degree[next] == 0) q.add(next); // 0이라면 큐에 넣어주기
				
				ans[next] = Math.max(ans[next], ans[v]); // 여기는 왜 최댓값을 구해주는건지..?..
			}
		}
	}
}
