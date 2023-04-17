package baekjoon_02_Silver;

import java.util.Scanner;

public class baekjoon2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int cnt5;
		int rest;
		int cnt3;

		cnt5 = N / 5;
		rest = N % 5;
		while (true) {
			if (rest % 3 != 0) {
				if(cnt5 == 0 && rest %3!=0) {
					sb.append(-1);
					break;
				}
				cnt5--;
				rest += 5;
			} else {
				break;
			}
		}
		cnt3 = (N - 5 * cnt5) / 3;
		if(sb.length()==0) {
			System.out.println(cnt5 + cnt3);
		} else {
			System.out.println(-1);
		}
		
	}
}
