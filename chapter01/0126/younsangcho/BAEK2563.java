package algorithm_Java;

import java.util.Scanner;

public class BAEK2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 100 x 100 배열 선언
		int[][] arr = new int[100][100];
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) { 
			int x = sc.nextInt();
			int y = sc.nextInt();
			// 해당 좌표로부터 x좌표 + 10, y좌표  + 10까지 전부 1 삽입
			for (int a=x; a<x+10; a++) for (int b = y; b < y+10; b++) arr[a][b] =1;
		}
		
		// 배열 중 원소가 1인 부분 전부 count
		for (int i = 0; i<100; i++) for(int j = 0; j<100; j++) if(arr[i][j]==1) cnt++; 
		
		System.out.println(cnt);
	}
}
