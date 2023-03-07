package study0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek25501 {
	public static int cnt=0;//recursion 호출 횟수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bfr.readLine());//문자열 갯수
		
		String S;//문자열 저장공간
		int result;//ispalindrome 최종결과 저장공간
		
		for(int i=0;i<T;i++) {
			cnt=0;//호출 횟수 초기화
			S=bfr.readLine();//읽어오기
			result=isPalindrome(S);//S 판별시작
			
			System.out.printf("%d %d\n",result,cnt);
		}
	}
	
	public static int recursion(String s, int l, int r){
	    cnt++;//recursion호출되었으므로 ++
		if(l >= r) return 1;
	    else if(s.charAt(l) != s.charAt(r)) return 0;
	    else return recursion(s, l+1, r-1);
	}

	public static int isPalindrome(String s){
	    return recursion(s, 0, s.length()-1);//끝문자끼리 호출
	}
}
//21304	384