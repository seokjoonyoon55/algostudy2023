package study0309;

import java.util.Scanner;

public class Baek15650_2 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();//최대 자연수
		int M = sc.nextInt();//고를 갯수

		int[] arr = new int[M];//고른 것 저장
		boolean[] used = new boolean[N];//사용 여부 저장

		tracking(arr, used, 0,0, N, M);//백트래킹 시작

		System.out.println(sb);//출력

		sc.close();
	}

	//백트래킹 
	public static void tracking(int[] arr, boolean[] used, int start, int depth, int N, int M) {
		// 원하는 만큼 골랐으면
		if (depth == M) {
			// sb에 저장 후 종료
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + 1).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			// 고른 적 없는 숫자면
			if (!used[i]) {
				// 배열에 숫자 저장
				arr[depth] = i;
				
				// 사용여부 표시 후 백트래킹, 이후 되돌림
				used[i] = true;
				tracking(arr, used, i, depth + 1, N, M);
				used[i] = false;
			}
		}

	}
}
