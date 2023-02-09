package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK25501 {
	public static int cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String S;	
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<T;i++) {
			S = br.readLine();
			cnt = 0;
			sb.append(isPalindrome(S)).append(cnt+"\n");
		}
		
		br.close();
		System.out.println(sb);
	}
	
	// 양 끝에서부터 확인하는 반복 작업 함수
	public static String recursion(String S, int l, int r) {
		cnt++;
		// 양 끝 점이 중간에서 만났을 때
		if (l>=r) return "1 ";
		// 알파벳 다르면 0
		else if (S.charAt(l) != S.charAt(r)) return "0 ";
		// 알파벳 같은 경우 끝 점을 안으로 한칸씩 이동
		else return recursion(S,l+1,r-1);
	}
	
	// 인덱스 0과 (len-1) 부터 시작
	public static String isPalindrome(String S) {
		return recursion(S,0,S.length()-1);
	}
}
