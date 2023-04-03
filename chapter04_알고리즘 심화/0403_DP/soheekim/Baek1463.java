package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1463 {
	// 상태 저장배열
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		//계산할 숫자 N
		int N = Integer.parseInt(bfr.readLine());

		// 상태 저장배열 할당. 0번 인덱스 사용안함
		res = new int[N + 1];

		// N에 대한 계산결과 출력
		System.out.println(cal(N));

	}

	// N을 1로 만드는 횟수 계산 메서드
	static int cal(int N) {
		//이미 계산된 것이 있으면 계산된 값 반환
		if (res[N] != 0)
			return res[N];

		//1이라면 0반환
		if (N == 1)
			return 0;

		//2,3이라면 1 저장 후 반환
		if (N == 2 || N == 3) {
			res[N] = 1;
			return 1;
		}

		//6으로 나눠지면
		if (N % 6 == 0) {
			//2로 나눈값 계산결과, 3으로 나눈 값 계산결과, -1한 계산결과 중 작은것 +1
			res[N] = 1 + Math.min(cal(N / 2), Math.min(cal(N / 3), cal(N - 1)));
		}
		//2로만 나눠지면
		else if (N % 2 == 0) {
			//2로 나눈값 계산결과, -1한 계산결과 중 작은것 +1
			res[N] = 1 + Math.min(cal(N / 2), cal(N - 1));
		}
		//3으로만 나눠지면
		else if (N % 3 == 0) {
			//3으로 나눈 값 계산결과, -1한 계산결과 중 작은것 +1
			res[N] = 1 + Math.min(cal(N / 3), cal(N - 1));
		}
		//2,3어느것으로도 나눠지지 않으면
		else {
			//-1한 계산결과 +1
			res[N] = 1 + cal(N - 1);
		}
		
		//계산 결과 반환
		return res[N];
	}

}
