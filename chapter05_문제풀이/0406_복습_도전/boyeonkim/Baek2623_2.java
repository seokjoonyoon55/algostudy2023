package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		in_degree = new int[N + 1];
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
				from = to;
			}
		}
		
		TopologicalSort();
		if(sb.length() != N * 2) System.out.println(0);
		else System.out.println(sb);
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
