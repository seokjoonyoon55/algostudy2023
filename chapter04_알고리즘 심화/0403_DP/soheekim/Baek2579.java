package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2579 {
	//계단 점수 저장
	static int[] stair;
	
	//계산 결과 저장
	static int[] res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		//계단 갯수 입력받기
		int N = Integer.parseInt(bfr.readLine());

		//계단 점수, 계산 결과 배열 할당
		stair = new int[N + 1];
		res = new int[N + 1];
		
		//계단 점수 입력받기
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(bfr.readLine());
		}
		
		//N번째 계단 dp돌린 결과 출력
		System.out.println(dp(N));

	}

	//N번 계단 최대점수 출력
	public static int dp(int N) {
		//음수 층 0 반환
		if(N<=0)
			return 0;
		
		//이미 계산됐으면 계산된 값 반환
		if (res[N] != 0)
			return res[N];

		//1이면 1층 점수 저장
		if (N == 1)
			res[N] = stair[N];
		//1이 아니면
		else
			//2칸+1칸으로 오거나, 2칸으로 오거나 둘 중 하나.
			//현재 층 점수 + max( -1층 점수 + -3층 계산값, -2층 점수)중 큰 값
			res[N] = stair[N] + Math.max(stair[N - 1] + dp(N - 3), dp(N - 2));

		//계산 결과 반환
		return res[N];
	}
}