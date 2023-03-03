package baekjoon;

import java.util.Scanner;

public class BAEK10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
	}
	
	public static int factorial(int N) {
		// 반환값 변수 선언 및 초기화
		int result = 0;
		
		// 초기값 설정
		if (N == 1) {
			return 1;
		} else if (N == 0) {
			return 1;
		// N > 2일 때 재귀
		} else {
			result = N * factorial(N-1);
		}
		return result;
	}
}
