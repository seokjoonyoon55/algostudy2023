package algorithm_Java;

import java.util.Scanner;

public class BAEK17608 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 받을 정수형 선언
		int N = sc.nextInt();
		
		// 입력 받은 숫자 크기의 배열 선언
        int[] arr = new int[N];
        
        // 배열에 element 삽입
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 맨 뒤 막대 기본적으로 1개 count
        int cnt = 1;
        // 맨 뒤에 있는 stick의 높이
        int stick = arr[arr.length - 1];
        
        // 뒤에서부터 count
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > stick) {
				cnt++;
                stick = arr[i];
			}
		}
		System.out.print(cnt);
        sc.close();
	}
}
