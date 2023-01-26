package study0126;

import java.util.Scanner;

public class Baek2566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] numBoard=new int[9][9];//숫자 저장 2차배열
		int max=-1;
		int itemp=-1;
		int jtemp=-1;
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				numBoard[i][j] = sc.nextInt();
		}//인풋 저장
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				if(numBoard[i][j]>max) {
					max=numBoard[i][j];
					itemp=i+1;
					jtemp=j+1;
				}
		}//최댓값 및 위치 저장

		//출력
		System.out.println(max);
		System.out.print(itemp+" "+jtemp);
		
		sc.close();
	}
}
