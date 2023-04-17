package algorithm_Java;

import java.util.Scanner;

public class BAEK2847 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 각 레벨의 점수를 담을 배열 선언
		int[] level = new int[N];
		// 제일 마지막 단계의 점수를 담을 변수 선언 및 초기화
		int max = 0;
		// 배열에 점수를 입력하고, 마지막 단계의 점수를 max 변수에 초기화한다.
		for (int i = 0; i < N; i++) {
			level[i] = sc.nextInt();
			if (i == N-1) max = level[i];
		}
		// 몇 번 감소시키는 지 count할 변수 선언 및 초기화
		int cnt = 0;
		for (int i = N-2; i >= 0; i--) {
			// 어려운 레벨보다 점수를 많이 받는 경우일 때
			if (level[i] >= max) {
				cnt += level[i] - (max - 1);
				max--; 
			// 아닐 경우 max update
			} else {
				max = level[i];
			}
		}
		System.out.println(cnt);
	}
}
