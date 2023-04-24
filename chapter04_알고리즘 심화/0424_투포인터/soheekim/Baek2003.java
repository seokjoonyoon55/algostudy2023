package study0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] tempS = bfr.readLine().split(" ");

		int N = Integer.parseInt(tempS[0]);// 수열 길이
		int M = Integer.parseInt(tempS[1]);// 목표 합
		int[] nums = new int[N];// 수 저장 배열
		int cnt = 0;// 목표 만족 수열 카운트

		// 숫자들 입력받기
		tempS = bfr.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tempS[i]);
		}

		int left = 0; // 수열의 왼쪽 포인터
		int right = 0;// 수열의 오른쪽 포인터
		int sum = 0;// 수열의 현재 합

		// 수열 왼쪽부터 시작
		for (left = 0; left < N; left++) {
			// 왼쪽이 짝수인덱스이면 오른쪽 포인터 증가
			if (left % 2 == 0)
				// 왼쪽 포인터 지점부터 끝까지 증가하면서 합 게산
				for (right = left; right < N; right++) {
					sum += nums[right];

					// 목표합에 일치하면 cnt++
					if (sum == M)
						cnt++;
				}
			// 왼쪽이 홀수인덱스이면 오른쪽 포인터 감소
			else
				// 오른쪽 끝부터 왼쪽 포인터에 접할 때까지 오른쪽 포인터--
				for (right = N - 1; right >= left; right--) {
					// 맨 끝이 아니라면 이동전 숫자를 합에서 빼기
					if (right != N - 1)
						sum -= nums[right + 1];

					// 목표합에 일치하면 cnt++
					if (sum == M)
						cnt++;
				}

			// 왼쪽 포인터 한칸 이동해서 수열 줄이면서 합에서 빼기
			sum -= nums[left];
		}

		// 목표합 일치 수열 갯수 출력
		System.out.println(cnt);

	}
}
