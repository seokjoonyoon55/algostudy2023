package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 계단 배열 선언
 		int[] stairs = new int[301];
		// dp 배열 선언
 		// 계단 점수를 최소로 만들 수 있는 dp 테이블
 		int[] dp = new int[301];
 		// 총 계단 점수 변수 선언 및 초기화
		int total = 0;
		for (int i = 1; i <= N; i++) {
			// 각 계단의 점수 초기화
			stairs[i] = Integer.parseInt(br.readLine());
			// 총 계단 점수에 더해주기
			total += stairs[i];
		}
		// 2보다 작거나 같을 경우 total이 곧 출력될 점수이다.
		if (N <= 2) {
			System.out.println(total);
			return;
		}
		// base case 초기화
		dp[1] = stairs[1];
		dp[2] = stairs[2];
		dp[3] = stairs[3];
		for (int i = 4; i <= N-1; i++) {
			// 연속된 3칸을 못올라가므로
			// i - 3과 i - 2 중 더 작은 값을 밟는게 이득 
			dp[i] = Math.min(dp[i-2], dp[i-3]) + stairs[i];
		}
		System.out.println(total-Math.min(dp[N-1], dp[N-2]));
	}
}