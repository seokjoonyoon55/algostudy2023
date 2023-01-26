package algostudy;

import java.util.Scanner;

public class baek4948 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		boolean[] arr = new boolean[246913];
		
		// 소수가 아니면 true
		arr[0] = true;
		arr[1] = true;
		
		for (int i=2;i<=Math.sqrt(arr.length);i++) {
			if (arr[i]) continue;
			for (int j=i*i;j<arr.length;j+=i) {
				arr[j] = true;
			}
		}
		
		int cnt = 0;
		
		while (true) {
			if (n==0) break;
			
			cnt = 0;
			for (int i=n+1;i<=2*n;i++) {
				if (!arr[i]) cnt++;
			}
			
			
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}
