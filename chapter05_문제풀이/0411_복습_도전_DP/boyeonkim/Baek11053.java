package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] num = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			dp[i] = 1; // dp 배열 최솟값 1
			num[i] = Integer.parseInt(st.nextToken());
		}
		int max = 1;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				// 현재 숫자가 이전 숫자보다 크다면 이전 원소들 중 가장 큰 DP값 + 1
				if(num[i] > num[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]); // 가장 큰 DP값 구하기
		}
		System.out.println(max);
	}
}
