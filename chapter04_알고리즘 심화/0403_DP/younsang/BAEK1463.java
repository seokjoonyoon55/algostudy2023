package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		// 10^6 크기의 배열 생성
		int[] dp = new int[1000005];
		int num = 0;
		// 초기값 설정 / 재귀에서 base case와 비슷한 맥락
		dp[1] = 0;
		// 1부터 위로 쌓아나가는 과정
		for (int i = 2; i <= X; i++) {
			dp[i] = dp[i-1] + 1;
			if (i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if (i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[X]);
	}	
}