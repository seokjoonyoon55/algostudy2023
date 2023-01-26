package baekjoonPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int a = 2 * n;
			int cnt = 0; // 나누는 횟수
			int numCnt = 0; // 숫자의 개수
			if (n == 1) { // 1은 따로 -> 2배 해도 2라 j for문 돌리기 애매함
				System.out.println(1);
			} else {
				for (int i = a; i > n; i--) {
					for (int j = 2; j < i; j++) {
						if (i % j == 0) { // i를 j(i보다 작은 수)로 나눴을 때 나머지가 0이면 소수가 아님
							cnt = 0;// i를 j로 나눴을 때 나머지가 0이면 다음 카운트를 위해 초기화
							break; // 더 나눌 필요없음
						} else {
							cnt++; // 나누는 횟수 증가
						}
//						System.out.println(cnt);
					}
					if (cnt != 0) {
						numCnt++; // 소수가 아닌 경우 계속 위에서 초기화 해줬으므로 cnt가 0이 아니면 개수 증가
					}

				}

				System.out.println((numCnt));
			}

		}
	}
}
