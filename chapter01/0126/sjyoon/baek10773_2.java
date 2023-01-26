package algostudy;

import java.util.Scanner;

public class baek10773_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int[] arr = new int[K];
		int val;
		int idx = 0;
		int cnt = 0;
		
		for (int i=0;i<K;i++) {
			val = sc.nextInt();
			if (val==0) {
				cnt++;
				idx = i;
			} else {arr[i-cnt]=val;}
		}
		
		int sum = 0;
		
		for (int i=0;i<K-cnt;i++) {
			if (i>idx-2*cnt && i<=idx-cnt) {
				continue;
			} else {sum+=arr[i];}
		}
		
		System.out.println(sum);
		
		sc.close();
		
		// len=10 idx=8 cnt=4
		// {1 3 5 4 7 6 0 0 0 0}
		// {1 3 5 4 0 0 7 0 0 6}
		//                  i
		//         i-c
		// i-2*c
	}
}
