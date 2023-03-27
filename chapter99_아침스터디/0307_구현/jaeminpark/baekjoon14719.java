package baekjoon_03_Gold;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon14719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[][] rain = new int[H][W];
		int cnt = 0;
		// 열 기준으로 블록 세우기
		for (int i = 0; i < W; i++) {
			int h = sc.nextInt();
			for (int j = H - 1; j >= H - h; j--) {
				rain[j][i] = 1;
			}
		}
//		for (int i = 0; i < H; i++) {
//			System.out.println(Arrays.toString(rain[i]));
//		}
//		System.out.println();
		// 각행에서 양 끝이 1이면 그 사이는 어차피 다 0이니깐 cnt++
		for (int i = 0; i < H; i++) {
			int startC = -1;
			int endC = -1;
			for (int j = 0; j < W; j++) {
				if (startC == -1 && rain[i][j] == 1) {
					startC = j;
				} else if (startC != -1 && rain[i][j] == 1) {
					endC = j;
				}
				if (startC != -1 && endC != -1) {
					for (int k = startC + 1; k < endC; k++) {
						cnt++;
					}
					startC = endC;
					endC = -1;
				}
			}
		}
//		for (int i = 0; i < H; i++) {
//			System.out.println(Arrays.toString(rain[i]));
//		}
		System.out.println(cnt);

	}

}
