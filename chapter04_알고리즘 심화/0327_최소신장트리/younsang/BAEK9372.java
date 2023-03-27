package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK9372 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
			}
			// 모든 노드가 연결되기 위한 최소 조건은 간선이 노드 - 1일 때임을 이용해서
			// V - 1 값을 출력
			sb.append(V-1).append("\n");
		}
		System.out.println(sb.toString());
	}
}