package study0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek14501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(bfr.readLine());
		int[] T=new int[N];//T 저장용 배열
		int[] P=new int[N];//N 저장용 배열
		String[] TN= new String[2];//TN 쪼개기 전
		
		//T와 N 쪼개서 입력받기
		for(int i=0;i<N;i++) {
			TN=bfr.readLine().split(" ");
			T[i]=Integer.parseInt(TN[0]);
			P[i]=Integer.parseInt(TN[1]);
		}
		
		System.out.println(search(0,T,P,N));
	}
	
	public static int search(int start,int[]T,int[]P, int N) {
		int max=0;//최대값 비교 저장용
		int res=0;//재귀 서치 값 저장용
		
		//start부터 다시 서치
		for(int i=start;i<N;i++) {
			//if 퇴사일 안넘기면
			if(i+T[i]<=N) {
				//결과 = (현재값+이후값서치)와 이전 최대값 중 큰 것
				res=P[i]+search(i+T[i],T,P,N);
				if(max<res) max=res;
			}
		}
		return max;
	}
}