package study0417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Baek2847 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bfr.readLine());// 레벨 수
		int[] level = new int[N];// 각 레벨 별 점수
		int reduce = 0;// 줄인 수

		// 레벨 별 점수 입력 받기
		for (int i = 0; i < N; i++) {
			level[i] = Integer.parseInt(bfr.readLine());
		}

		// System.out.println(Arrays.toString(level));

		// 높은 레벨부터 반복
		for (int i = N - 1; i > 0; i--) {
			// i-1번째가 i번쨰보다 작다면
			if (level[i - 1] >= level[i]) {
				// i번째-1로 줄이는 만큼 reduce에 더하고 i-1번째 갱신
				reduce += level[i - 1] - level[i] + 1;
				level[i - 1] = level[i] - 1;
			}
		}
		System.out.println(reduce);

	}
}
