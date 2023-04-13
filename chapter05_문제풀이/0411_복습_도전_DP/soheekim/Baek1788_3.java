package day0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1788_3 {
	static long[] fiboRes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bfr.readLine());
		long res = 0;

		// 절댓값 계산
		int absn = Math.abs(N);

		// 결과값 저장배열
		fiboRes = new long[absn + 1];

		// 절대값이 0이 아니면 1초기화
		if (absn != 0)
			fiboRes[1] = 1;

		// 계산시작점 설정
		int num = 2;

		// 입력 도달할 때까지 피보나치 계산
		while (num <= absn) {
			fiboRes[num] = (fiboRes[num - 2] + fiboRes[num - 1]) % 1000000000;

			num++;
		}
		// 결과값 저장
		res = fiboRes[absn];

		// 양수입력이면 무조건 양수
		if (N > 0)
			System.out.println(1);
		// 0입력이면 무조건0
		else if (N == 0)
			System.out.println(0);
		// 음수입력이면
		else {
			// 홀수번째일 때 양수
			if (absn % 2 == 1)
				System.out.println(1);
			// 짝수번째일 때 음수
			else
				System.out.println(-1);
		}

		//결과값 출력
		System.out.println(Math.abs(res % 1000000000));

	}

}
