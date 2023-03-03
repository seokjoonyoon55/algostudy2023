package chapter03;

import java.util.Scanner;

public class BAEK10872 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		int val = 1;
		
		
		for (int i=1;i<=N;i++) {
			val=val*i;
		}
		
		System.out.println(val);
	}
}
