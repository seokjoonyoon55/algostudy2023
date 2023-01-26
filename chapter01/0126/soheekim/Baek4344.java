package study0126;

import java.util.Scanner;

public class Baek4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC=sc.nextInt();//테스트케이스 갯수
		int student=0;//학생 수
		int sum=0;//합
		int overCnt=0;//평균 넘는 수
		double avg=0;//평균 저장용 변수
		double percent=0;
		
		for(int i=0;i<TC;i++) {
			student=sc.nextInt();
			int[] score=new int[student];//학생수 크기 배열 생성
			
			//테스트 케이스마다 초기화
			sum=0;
			overCnt=0;
			
			//저장 및 총합 계산
			for(int j=0;j<student;j++) {
				score[j]=sc.nextInt();
				sum+=score[j];
			}
			
			avg=(double)sum/student;//평균계산
			
			//평균 넘는 학생 카운트
			for(int j=0;j<student;j++) {
				if(score[j]>avg) overCnt++;
			}
			
			//퍼센트 계산 및 출력
			percent = ((double)overCnt)/student*100;
			System.out.printf("%.3f%%\n",percent);
		}
		sc.close();
	}
}
