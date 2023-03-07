package chapter01;

import java.util.Scanner;

public class baek1769 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String X = sc.next();
		int cnt = 0;
		int result;
		
		while (true) {
			if (X.length()==1) {
				result = Integer.valueOf(X);
				break;
			} else {
				int sum = 0;
				for (int i=0;i<X.length();i++) {
					sum+=Character.getNumericValue(X.charAt(i));
				}
				cnt+=1;
				X = Integer.toString(sum);
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
