package study0126;

import java.util.Scanner;

public class Baek1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 무조건 3자리 이하. 1000은 한수가 아니므로 상관X
		int n100;// 100의 자릿수
		int n10;// 10의 자릿수
		int n1;// 1의 자릿수
		int temp = T;
		int hancount = 0;// 100이상&한수인 수 카운트

		if (T >= 100) {// 100이상이면
			for (int i = 101; i <= T; i++) {
				n100 = i / 100;// 100의 자릿수
				n10 = (i / 10) % 10;// 10의 자릿수
				n1 = i % 10;// 1의 자릿수
				if (n1 == 2 * n10 - n100)// 1000일땐 조건문 만족하지 못하므로 상관 X
					hancount++;
			}
			temp = 99 + hancount;// 한수 갯수로 바꿈
		}
		System.out.println(temp);
		sc.close();
	}
}
// 한수 조건 : 100의 자리 x, 10의 자리 y일 때 1의 자리 2y-x
