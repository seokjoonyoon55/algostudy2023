package study0130;

import java.util.Scanner;

public class Baek9012_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int status=0;

		String indata;

		for (int tc = 0; tc < T; tc++) {
			status=0;
			indata = sc.next();
			for (int i = 0; i < indata.length(); i++) {
				if (indata.charAt(i) == '(') status++;
				else status--;
				if(status<0) break;	
			}
			
			if (status==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
