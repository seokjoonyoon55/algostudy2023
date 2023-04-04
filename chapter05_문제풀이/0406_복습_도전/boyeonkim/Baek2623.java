package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2623_음악프로그램 {
	static int N, M;
	static int[] in_degree;
	static List<Integer>[] list;
	static List<Integer> res = new ArrayList<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 가수의 수
		M = Integer.parseInt(st.nextToken()); // 보조PD의 수
		
		in_degree = new int[N + 1]; // 진입차수 배열
		list = new ArrayList[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < size - 1; j++) {
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				in_degree[to]++;
				from = to; // 그 다음에 계속해서 연결해주기 위해
			}
		}
		
		TopologicalSort();
		// 순서 정하는 것이 가능한 경우
		// 결과를 담은 리스트의 크기가 가수의 수와 일치한다면 결과 출력
		if(res.size() == N) {
			for(int i : res) {
				System.out.println(i);
			}
		// 아니라면 0 출력
		} else System.out.println(0);
	}

	static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(in_degree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int n = q.remove();
			res.add(n);
			for(int i = 0; i < list[n].size(); i++) {
				int v = list[n].get(i);
				in_degree[v]--;
				if(in_degree[v] == 0) q.add(v);
			}
		}
	}
}
