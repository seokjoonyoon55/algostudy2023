package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon15654 {

	static int N;
	static int M;
	static int[] nums;
	static int[] answer;
	static boolean[] isUsed;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isUsed = new boolean[N];
		nums = new int[N];
		answer = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		bt(0);
		System.out.println(sb.toString());
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
				isUsed[i] = true;
				answer[depth] = nums[i];
				bt(depth + 1);
				isUsed[i] = false;
			}
		}
	}
}
