package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15652 {

	static int N;
	static int M;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		bt(0);

	}

	static void bt(int depth) {
		if (depth == M) {
			boolean flag = true;
			for(int i = 0; i<answer.length-1; i++) {
				if(answer[i] > answer[i+1]) {
					flag = false;
				}
			}
			if(flag) {
				for(int i = 0; i<answer.length; i++) {
					System.out.print(answer[i] + " ");
				}
				System.out.println();
			}
			
			return;
		}

		for (int i = 1; i <= N; i++) {
			answer[depth] = i;
			bt(depth + 1);
		}
	}
}
