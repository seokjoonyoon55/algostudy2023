package chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK10828 {
	public static void main(String[] args) throws IOException {
		
		Stack<Integer> stk = new Stack<>();
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		
		for (int i=0;i<N;i++) {
			
			// 입력 받아서 바로 토큰화
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			String com = st.nextToken();
			
	
			if (com.equals("push")) {
				stk.push(Integer.parseInt(st.nextToken()));
			} 
			
			// 스택이 비어있을시 오류 발생하므로 try-catch문 썼음
			else if (com.equals("pop")) {
				try {
					System.out.println(stk.pop());
				} catch (Exception e) {
					System.out.println(-1);
				}
			} 
			
			else if (com.equals("size")) {
				System.out.println(stk.size());
			} 
			
			else if (com.equals("empty")) {
				if (stk.empty()) {
					System.out.println(1);
				} else {System.out.println(0);}				
			}
			
			// 스택이 비어있을시 오류 발생하므로 try-catch문 썼음
			else {
				try {
					System.out.println(stk.peek());
				} catch (Exception e) {
					System.out.println(-1);
				}
			}
			
		}
		
		br.close();
		
	}
}
