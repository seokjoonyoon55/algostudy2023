package chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.Scanner;
import java.util.Stack;

public class BAEK10828_3 {
	public static void main(String[] args) throws IOException {
		
		Stack<Integer> stk = new Stack<>();
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		
		for (int i=0;i<N;i++) {
			
			// 입력 받아서 바로 토큰화
			String s = br.readLine();
			
			
				
			// 스택이 비어있을시 오류 발생하므로 try-catch문 썼음
			if (s.equals("pop")) {
				try {
					System.out.println(stk.pop());
				} catch (Exception e) {
					System.out.println(-1);
				}
			} 
			
			else if (s.equals("size")) {
				System.out.println(stk.size());
			} 
			
			else if (s.equals("empty")) {
				if (stk.empty()) {
					System.out.println(1);
				} else {System.out.println(0);}				
			}
			
			// 스택이 비어있을시 오류 발생하므로 try-catch문 썼음
			else if (s.equals("top")) {
				try {
					System.out.println(stk.peek());
				} catch (Exception e) {
					System.out.println(-1);
				}
			}
			
			else {
				String arr[] = s.split(" ");
				stk.push(Integer.parseInt(arr[1]));
			} 
			
		}
		
		
		br.close();
	}
}
