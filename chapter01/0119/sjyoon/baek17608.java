package chapter01;

import java.util.Scanner;

public class baek17608 {
	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] arr = new int [N];
		
		for (int i=0;i<N;i++) {
			int len = sc.nextInt();
			arr[N-i-1] = len;
		}
		
		int cnt = 1;
		int max = arr[0];
		
		for (int i=1;i<N;i++) {
			if (arr[i]>max) {
				cnt+=1;
				max = arr[i];
			}
		}
		
		System.out.println(cnt);
	}
}
