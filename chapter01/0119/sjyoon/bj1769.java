package chapter01;

import java.util.Scanner;

public class bj1769 {
	public static void main(String[] args) {
		// 1234567 / 10^6 = 1
		// 1234567 / 10^5 = 12
		// 1234567 / 10^4 = 123
		// 1234567 / 10^3 = 1234
		// 1234567 / 10^2 = 12345
		// 1234567 / 10^1 = 123456
		// 1234567 / 10^0 = 1234567
		
		Scanner sc = new Scanner(System.in);
		
		long num = sc.nextLong();
		long cnt = 0;
		long result = 0;
		
		while (true) { 
			if (num<10) {
				result = num;
				break;
			} else {
				long n = (long)(Math.log10(num)+1);
				long sum = 0;
				for (long i=0;i<n;i++) {
					sum+=num/Math.pow(10, i)%10;
				}
				cnt+=1;
				num = sum;
			}
		}
		
		System.out.println(cnt);
		if (result%3==0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
