package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon10972 {

	static int N;
	static int[] nums;
	static boolean same;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		nextPerm();
		System.out.println(sb);
	}

	private static void nextPerm() {
		int x = N - 1;
		while (x > 0 && nums[x - 1] > nums[x]) {
			x--;
		}
		if (x <= 0) {
			sb.append(-1);
			return;
		}
		int y = N - 1;

		while (nums[x - 1] >= nums[y]) {
			y--;
		}

		int temp = nums[y];
		nums[y] = nums[x - 1];
		nums[x - 1] = temp;

		y = N - 1;

		while (x < y) {
			temp = nums[x];
			nums[x++] = nums[y];
			nums[y--] = temp;
		}

		for (int i : nums) {
			sb.append(i).append(" ");
		}
	}
}
