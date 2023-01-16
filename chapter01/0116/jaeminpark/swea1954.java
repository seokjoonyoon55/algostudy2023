package study230116;

import java.util.Scanner;

public class swea1954 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int a = sc.nextInt();
			int[][] snail = new int[a][a];
			int k = 1;
			int b = 0;
			if (a == 1) {
				snail[0][0] = 1;
			}
			while (snail[b][b] == 0) {
				for (int i = b; i < a - b; i++) {
					snail[b][i] = k;
					k++;// 오른쪽
				}
				for (int i = b + 1; i < a - b; i++) {
					snail[i][a - 1 - b] = k;
					k++;// 아래
				}
				for (int i = a - 2 - b; i >= b; i--) {
					snail[a - 1 - b][i] = k;
					k++;// 왼쪽
				}
				for (int i = a - 2 - b; i >= b + 1; i--) {
					snail[i][b] = k;
					k++;// 위
				}
				b++;
			}
			;

			System.out.println("#" + test_case);
			for (int i = 0; i < snail.length; i++) {
				for (int j = 0; j < snail[i].length; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
