package study0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2839 {
	static int[] w;
	static int[][] knapsack;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bfr.readLine());// 목표 무게
		w = new int[] { 3, 5 };// 설탕 봉지 무게
		knapsack = new int[2][N + 1];// 결과 저장 배열

		int res = dp(1, N);// 배낭 dp

		// 출력
		System.out.println(res);

//		System.out.println(Arrays.toString(knapsack[0]));
//		System.out.println(Arrays.toString(knapsack[1]));
	}

	// 배낭알고리즘 dp
	public static int dp(int idx, int W) {
		// 남은 무게가 0이면 0반환
		if (W <= 0)
			return 0;

		// 남은 무게가 있으면
		// 3키로 설탕이면
		if (idx == 0) {
			// 3으로 나눠 떨어지면 몫 저장
			if (W % w[idx] == 0)
				knapsack[idx][W] = W / w[idx];
			// 나누어 떨어지지 않으면 -1 저장
			else
				knapsack[idx][W] = -1;
		}
		// 5키로 설탕이면
		else {
			// 5로 나누어 떨어지면 몫 저장, 아니면 int 최대 저장
			knapsack[idx][W] = W % w[idx] == 0 ? W / w[idx] : -1;

			// 5키로 설탕봉지 i개 선택 반복
			for (int i = 0; i <= W / w[idx]; i++) {
				// 5키로 설탕봉지 i개 선택한 나머지 무게에 대해 3키로 설탕 dp돌림
				int temp = dp(idx - 1, W - i * w[idx]);

				// 3키로 설탕 결과가 -1이 아니라 나누어 떨어진다면
				if (temp != -1)
					// 기존값, 3키로 설탕결과+5키로i개 중 최소값으로 갱신
					if (knapsack[idx][W] == -1)
						knapsack[idx][W] = temp + i;
					else
						knapsack[idx][W] = Math.min(knapsack[idx][W], temp + i);
			}

		}
		// 결과값 반환
		return knapsack[idx][W];
	}
}
