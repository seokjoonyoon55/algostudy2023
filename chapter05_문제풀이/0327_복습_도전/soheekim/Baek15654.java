package study0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek15654 {
	static int N;// 최대 수
	static int M;// 뽑을 갯수
	static StringBuilder sb = new StringBuilder();
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		// N M 입력받기
		String[] NM = bfr.readLine().split(" ");
		N = Integer.parseInt(NM[0]);// 최대 수
		M = Integer.parseInt(NM[1]);// 뽑을 갯수

		nums = new int[N + 1];

		String[] tempS = bfr.readLine().split(" ");

		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tempS[i - 1]);
		}

		Arrays.sort(nums);

		// 1부터 숫자 시작하고, 현재 0개 선택된 상태로, 만들어진 문자열은 ""인, 순열 만드는 메서드 시작
		perm(1, 0, "");

		System.out.println(sb);
	}

	// 현재 selected개 선택상태로 순열 만드는 메서드
	public static void perm(int selected, int flag, String madeS) {
		// M개 선택됐으면
		if (selected > M) {
			// sb에 저장하고 개행 입력
			sb.append(madeS).append("\n");
			return;
		}

		// M개 선택되지 않았으면
		// start부터 N까지의 숫자에 대해
		for (int i = 1; i <= N; i++) {
			if ((flag & (1 << i)) != 0)
				continue;

			// 선택수+1 상태로 조합 돌림
			perm(selected + 1, flag | (1 << i), madeS + nums[i] + " ");
		}
	}
}
