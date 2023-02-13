package algostudy;

import java.util.Scanner;

public class BAEK11729_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(hanoi(3));
		
		
	}
	
	
	
	// 최소 횟수 구하는 재귀
	static int hanoi(int n) {
		if (n==1) return 1;
		else return hanoi(n-1)*2+1;
	}
	
}
