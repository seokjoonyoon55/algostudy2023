package baekjoon;

import java.util.Scanner;

public class Baek26099 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		
		if(N >= 3) dp[3] = 1;
		if(N >= 5) dp[5] = 1;
		for(int i = 6; i <= N; i++) {
			// 5의 배수일 경우 이전 5kg 봉다리 1개 추가
			if(i % 5 == 0) {
				dp[i] = dp[i - 5] + 1;
			// 3의 배수일 경우 이전 3kg 봉다리 1개 추가
			} else if(i % 3 == 0) {
				dp[i] = dp[i - 3] + 1;
			} else {
				// 3kg와 5kg 봉다리로 만들 수 있는 숫자일 경우
				// 더 작은 값에서 한 봉지 추가
				if(dp[i - 3] != 0 && dp[i - 5] != 0) {
					dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
				}
			}
		}
		// 만들 수 없는 경우엔 dp 배열의 값이 0이기 때문에 -1 출력
		if(dp[N] == 0) {
			System.out.println(-1);
		} else System.out.println(dp[N]);
	}
}
