package study0119;

import java.util.Scanner;
public class baek17608 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N=sc.nextInt();//막대 갯수
		int[] sticks=new int[N];//막대높이 배열
		int front;//보이는지 안보이는지 판단하는 기준점의 높이
		int cansee;//보이는 갯수
		
		for(int i=0;i<N;i++) {
			sticks[N-1-i]=sc.nextInt();
		}//막대 높이들 입력받기. 편의를 위해 배열에 거꾸로 저장
		
		front=sticks[0];
		cansee=1;//맨 앞 지정 및 보이는 갯수1
		for(int j=0;j<N;j++) {
			if(sticks[j]>front) {
				front=sticks[j];
				cansee++;//앞에 보이는 것보다 크면 기준점으로 바꾸고 보이는 갯수++
			}
		}
		System.out.print(cansee);
		sc.close();
	}
}
