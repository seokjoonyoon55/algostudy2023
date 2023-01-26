package chapter01;

import java.util.Scanner;

public class baek2566 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int [9][9];
		// 최대값과 그 위치의 행과 열의 값 초기화
		int max = 0;
		int row =1;	
		int col =1;
		
		// 행렬에 값 입력시마다 max변수와 대소 비교 후, 값과 좌표 갱신
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j]>max) {
					max = arr[i][j];
					row = i+1;
					col = j+1;
				}
			}
		}
		
		System.out.print(max+"\n"+row+" "+col);
		
	}
}
