package study0119;

import java.util.Scanner;

public class baek1769 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String firstX = sc.next();//자연수 입력받음
		long X=-1;
		int cnt=0;//변환횟수 저장.
		long added=0;//자릿수 합
		String str;//변환 과정에서 쓸 문자열 저장용 임시변수
		
		do {
			if(X==-1) {//첫진입이면 
				str=firstX;//받은 문자열 그대로 삽입.
				if(str.length()==1)cnt--;//1의자리라면 첫진입때 변환이 일어나지 않음에도 아래에서 cnt++되므로 미리 빼주기
				}
			else str = Long.toString(X);  //첫 진입이 아니면 X 숫자를 문자열로 반환
			
			for(int i=0;i<str.length();i++) { //문자열 길이만큼 문자 하나씩 보고
				added=added+str.charAt(i)-48;//문자 아스키코드 - 0의 아스키코드 48을 합산
			}
			
			X=added;//다음 반복 위해 자릿수 합을 X에 저장
			added=0;//다음 반복 위해 자릿수 합 리셋
			cnt++;//변환횟수++
		}while(X>=10&&X!=-1);//X가 한자릿수 되면 스탑
		
		System.out.println(cnt);
		if(X%3==0) System.out.print("YES");
		else System.out.print("NO");
		
		sc.close();
	}
}
