package baekjoon;

import java.util.Scanner;

public class BAEK25501 {
	
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			cnt = 0;
			System.out.println(isPalindrome(sc.next()) + " " + cnt);
		}
		
		sc.close();
	}
	
	// (문자열, 맨 앞의 인덱스 값, 맨 뒤의 인덱스 값)
	static int recur(String s, int l, int r){
		cnt++;
		// 길이가 1일 때 이거나 중간값에 도달했을 때 ex) ABABA의 가운데 A값
        if(l >= r) return 1;
        // 앞의 idx와 뒤의 idx가 일치하지 않으면 팰린드롬이 아니므로 0 return
        else if(s.charAt(l) != s.charAt(r)) return 0;
        // if문과 else if문 둘 다 성립하지 않을 때 다음 재귀
        else return recur(s, l+1, r-1);
    }
	
	static int isPalindrome(String s){
        return recur(s, 0, s.length()-1);
    }
}
