package chapter01;

import java.util.Scanner;

public class baek10773 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		int K = sc.nextInt();
		int[] arr = new int[K];
		int cnt = 0;
		
		for (int i=0;i<K;i++) {
			arr[i] = sc.nextInt();
			if (arr[i]==0) {
				cnt++;
			}
		}
		
		int[] arr2 = new int[K-cnt];
		*/
		
		
		int K = sc.nextInt();
		int[] arr = new int[K];
		int idx = 0;	// 0이 나왔을 때 지워야 하는 최근 값의 인덱스
		
		for (int i=0;i<K;i++) {
			arr[i] = sc.nextInt();
			// 재현이가 0을 외쳤을 때
			if (arr[i]==0) {
				arr[idx] = 0;	// 인덱스가 가르키는 숫자 0으로 만들기
				
				// i번째 수부터 밑으로 조회해서, 0값이 아닌 가장 최근의 값 인덱스로 조정
				for (int j=i;arr[j]==0&&j>0;j--) {
					idx = j-1;
				}
				
			} else {
				idx = i;	// 제대로 된 수를 불렀을 때 인덱스 값 조정
			}
		}
		
		// 배열에 남아있는 합 구하기
		int sum = 0;
		
		for (int i=0;i<K;i++) {
			sum+=arr[i];
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
