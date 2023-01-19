package algorithm_Java;

import java.util.Scanner;

public class BAEK12605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			// 공백 기준으로 나눈 배열 생성
			String[] strArr = str.split(" ");
			System.out.printf("Case #%d:", i+1);
			// 뒤부터 출력
			for (int j = strArr.length - 1; j >= 0; j--) {
				System.out.printf(" %s", strArr[j]);
			}
			System.out.println();
		}
		sc.close();
	}
}
