package algostudy;

import java.util.Scanner;
import java.util.Stack;

public class BAEK11729 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 장대의 상황을 스택으로 표현
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		Stack<Integer> st3 = new Stack<>();
		
		// 첫번째 장대(스택)에 원판 초기 세팅
		for (int i=N;i>0;i--) {
			st1.push(i);
		}
		
		
		
	}
}
