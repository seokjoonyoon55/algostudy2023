package study0309;

import java.util.Scanner;

public class Baek15649 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[M];
		boolean[] used = new boolean[N];

		tracking(arr, used, 0, N, M);

		System.out.println(sb);

		sc.close();
	}

	public static void tracking(int[] arr, boolean[] used, int depth, int N, int M) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + 1).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				arr[depth] = i;
				used[i] = true;
				tracking(arr, used, depth + 1, N, M);
				used[i] = false;
			}
		}
	}
}
