package chapter01;

import java.util.Scanner;

public class baek1065 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 변수 지정
		int N = sc.nextInt();
		int cnt = 0;
		
		// 1~N 까지 숫자 중 한수가 나오면 cnt를 1씩 더하는 반복문
		for (int i=1;i<=N;i++) {
			if (i<100) {cnt++;}		// 2자리수 이하는 무조건 한수
			else if (i<1000) {		
				if ((i/100)+(i%10)==2*(i/10%10)) {cnt++;}	// (백의자리)+(일의자리)=2*(십의자리)
			}	
			else {break;}			// N이 1000인 경우
		}
		
		// 개수 출력
		System.out.println(cnt);
	
		sc.close();
	}
}
