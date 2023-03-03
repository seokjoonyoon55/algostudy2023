package baekjoon;

import java.util.Scanner;

public class BAEK10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(Fibonacci(N));	
	}
	
	static int Fibonacci(int N) {
		// 초기 반환값 설정
		if (N == 0) return 0;
		if (N == 1) return 1;
		// 재귀로 반환값 설정
		return Fibonacci(N-1) + Fibonacci(N-2);
	}
}
