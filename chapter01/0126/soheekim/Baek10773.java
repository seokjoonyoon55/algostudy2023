package study0126;

import java.util.Scanner;

public class Baek10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();//숫자 갯수
		
		int[] paper = new int[N];//숫자 스택 저장할 배열
		int indexCnt=0;//현재 스택 위치
		int temp=0;//입력 저장할 임시변수
		int sum=0;//합
		
		//입력 따라 쓰고 지우기
		for(int i=0;i<N;i++) {
			temp=sc.nextInt();
			
			if(temp==0 && indexCnt!=0) { //입력이 0이고 현재 스택에 숫자가 있을 경우
				paper[--indexCnt]=0;//이전칸으로 포인터 돌아가서 0으로 초기화하기
			}
			else {
				paper[indexCnt++]=temp;//입력이 0이 아닐 경우 숫자 넣고 포인터 앞으로
			}
		}
		
		for(int i=0;i<N;i++) {
			sum+=paper[i];
		}//합 구하기
		
		System.out.println(sum);
		sc.close();
	}
}
