package baekjoonPractice;

import java.util.Scanner;

public class baekjoon2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 색종이 개수
		int[][] board = new int[100][100];
		int startRow;
		int startColumn;
		int sum=0;

		for (int i = 0; i < n; i++) {
			startRow = sc.nextInt();
			startColumn = sc.nextInt();
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					board[startRow+j][startColumn+k] = 1;
				}
			}
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j<100; j++) {
				sum+=board[i][j];
			}
		}
		System.out.println(sum);
	}

}
