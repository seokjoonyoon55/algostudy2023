package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] rect = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				rect[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				// 현재 위치를 기준으로 ↖ ↑ 위치 중 최댓값에 현재 위치의 rect 값 더해서 dp배열에 저장
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + rect[i][j];
				// 마지막 배열일 때 최댓값 구해주기
				if(i == N) max = Math.max(dp[N][j], max);
			}
		}
		System.out.println(max);
	}
}
