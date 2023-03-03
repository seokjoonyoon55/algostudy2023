package chapter03;

import java.util.Scanner;

public class BAEK10872_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		int val = fac(N);
				
		System.out.println(val);
		
	}
	
	
	public static int fac(int N) {
		if (N==0) return 1;
		return N * fac(N-1);
	}
}

// 버퍼드랑 스캐너랑 시간 차이가 유의미한 정도인가...?