package baekjoonPractice;

import java.util.Scanner;

public class baekjoon2566 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] board = new int[9][9];
		int max = 0;
		int row = 0;
		int column = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = sc.nextInt();

				if (board[i][j] >= max) {
					max = board[i][j];
					row = i+1;
					column = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(row + " " + column);

	}

}
