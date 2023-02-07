package baekjoon_01_Bronze;

import java.util.Scanner;

public class baekjoon10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(fbnci(n));

	}

	public static int fbnci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			return fbnci(n-1) + fbnci(n-2);
		}
	}

}
