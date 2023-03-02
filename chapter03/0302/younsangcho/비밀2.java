package swea;

import java.util.Scanner;
public class 비밀2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			// 점수
			int[] score = new int[101];
			// 최저점
			int K_MIN = sc.nextInt();
			// 최고점
			int K_MAX = sc.nextInt();
			// 그룹
			int[] group = new int[3];
			// 점수 담기
			for (int i = 0; i < N; i++) {
				score[sc.nextInt()]++;
			}
			
			// 틀린 풀이임.
			// 반례가 존재함.
			// 어케 맞았누??
			
			// 평균 인원
			int avg = N / 3; 
			for (int i = 1; i <= 100; i++) {
				if (score[i] > 0) {
					// 평균인원보다 적으면 담기
					if (group[0] < avg) group[0] += score[i];
					// 평균인원보다 적으면 담기
					else if (group[1] < avg) group[1]+= score[i];
					// 앞에 두 칸 꽉 찼으니까 담기
					else group[2]+= score[i];
				}
			}
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			boolean check = true;
			for (int i : group) {
				// 최고 최저 점수 만족 못하면 -1 출력.
				if (i < K_MIN || i > K_MAX) check = false;
				if (i > max) max = i;
				if (i < min) min = i;
			}
			if (check) System.out.println(max-min);
			else System.out.println(-1);
		}
	}
}
