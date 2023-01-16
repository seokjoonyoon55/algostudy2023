package study230116;

import java.util.Scanner;

public class swea1926 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 1; i < n + 1; i++) {
			String I = Integer.toString(i);
			for (int j = 0; j < I.length(); j++) {
				int k = I.charAt(j) - '0';
				if (k == 3 || k == 6 || k == 9) {
					I = "-";
				}
				for (int l = 1; l < n + 1; l++) {
					if (i == 3 * (10 * l + 1) || i == 3 * (10 * l + 2) || i == 3 * (10 * l + 3)) {
						I = "--";
					}
				}
			}
			System.out.print(I + " ");
		}

	}

}
