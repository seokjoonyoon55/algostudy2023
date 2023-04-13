package study0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9084_그리디시간초과 {

	static int N, count;
	static int[] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bfr.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bfr.readLine());
			count = 0;

			String[] tempS = bfr.readLine().split(" ");
			coin = new int[N];

			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(tempS[i]);
			}

			int maxValue = Integer.parseInt(bfr.readLine());

			greedy(N - 1, maxValue);
			System.out.println(count);

		}
	}

	public static void greedy(int idx, int rest) {
		//System.out.println(idx+" "+rest);
		if (rest == 0) {
			count++;
			return;
		}
		if (idx < 0)
			return;

		if (coin[idx] > rest)
			return;

		for (int i = 0; i <= rest / coin[idx]; i++) {
			if (idx > 0)
				greedy(idx - 1, rest - i * coin[idx]);
			else {
				if (rest - i * coin[idx] == 0)
					count++;
			}
		}

		return;
	}
}
