package baekjoon_02_Silver;

import java.util.Scanner;

public class baekjoon1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.next();
		char[] C = s.toCharArray();
		// 답 출력 할거
		int sum = 0;
		// 마이너스가 있는지 여부
		boolean minus = false;
		for (int i = 0; i < C.length; i++) {
			if (C[i] != '-' && C[i] != '+') {
				sb.append(C[i]);
			} else {
				if (minus) {
					sum -= Integer.parseInt(sb.toString());
					sb.setLength(0);
				} else {
					sum += Integer.parseInt(sb.toString());
					sb.setLength(0);
				}
				if (C[i] == '-') {
					minus = true;
				}
			}
		}
		// 마지막 처리
		if(minus) {
			sum -= Integer.parseInt(sb.toString());
		} else {
			sum += Integer.parseInt(sb.toString());
		}
		System.out.println(sum);

	}

}
