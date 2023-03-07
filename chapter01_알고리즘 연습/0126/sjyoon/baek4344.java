package algostudy;

import java.util.Scanner;

public class baek4344 {
	public static void main(String[] args) {
		
		/*
		 * 실행 누르면 마지막 케이스 전까지는 출력이 되는데, 마지막 케이스는 엔터를 눌러야지만 뜨는 중...
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int N;
		int sum;
		int cnt;
		double ratio;
		
		for (int i=0;i<C;i++) {
			N = sc.nextInt();
			int [] arr = new int [N];	// 케이스별로 배열 만들기
			sum = 0;
			
			// 평균 구하기 위한 합
			for (int j=0;j<N;j++) {
				arr[j] = sc.nextInt();
				sum+=arr[j];
			}
			
			cnt = 0;
			
			// 평균 넘는 학생수 count
			for (int j=0;j<N;j++) {
				if (arr[j]>sum/N) {cnt++;}
			}
			
			ratio = (double)cnt/N*100;
			// System.out.printf("\n%.3f%%",ratio);
			System.out.printf("%.3f%%",ratio);
			System.out.println();
		}
		
		sc.close();
		
	}
}
