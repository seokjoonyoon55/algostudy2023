package baekjoon_01_Bronze;

import java.util.Scanner;

public class baekjoon10872 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		if(N == 0) {
			System.out.println(1);
		} else {
			System.out.println(p(N));
		}
	}	
	
	public static int p(int N) {
		if(N == 1) {
			return N;
		} else {
			return N*p(N-1);
		}
	}
}
