package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon15651 {

	static StringBuilder sb = new StringBuilder();
	static int[] answer;
	static int[] nums;
	static boolean[] isUsed;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		nums = new int[N];
		isUsed = new boolean[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		bt(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void bt(int depth) {
		if (depth == M) {
			for (int i = 0; i < answer.length; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isUsed[i]) {
				answer[depth] = nums[i];
				bt(depth + 1);
			}
		}
	}
}
