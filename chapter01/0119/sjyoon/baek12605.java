package chapter01;

import java.util.Scanner;

public class baek12605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// Scanner.nextInt 메소드는 사용자 입력의 가장 마지막 개행문자(엔터, newline)를 제거하지 않음
		sc.nextLine();
		
		String [] cases = new String [N];
		for (int i=0;i<N;i++) {
			String sen = sc.nextLine();
			cases[i] = sen;
		}
		
		for (int i=0;i<N;i++) {
			String [] words = cases[i].split(" ");
			System.out.printf("Case #%d: ",i+1);
			
			for (int j=words.length-1;j>=0;j--) {
				if (j==0) {
					System.out.print(words[j]+"\n");
				} else {
					System.out.print(words[j]+" ");
				}
			}
		}
	}
}
