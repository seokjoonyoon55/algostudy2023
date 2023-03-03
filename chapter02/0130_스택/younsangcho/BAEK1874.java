package algorithm_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BAEK1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		// 스택 선언
		Stack<Integer> stack = new Stack<>();
		
		// 문자열 담을 StringBuilder 선언
		StringBuilder sb = new StringBuilder();
		
		// 스택에 push하는 숫자 선언 및 초기화
		int number = 0;
		
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			// ex) 입력된 숫자가 4일 경우 1,2,3,4 스택에 push
			if (m > number) {
				for (int j = number + 1; j <= m; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				number = m;
			// 스택의 상단부와 입력된 값이 일치하지 않을 경우는 
			// 불가능한 경우이므로 NO 삽입
			} else if (stack.peek() != m)  {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			
			// 스택 상단부 제거 
			stack.pop();
			sb.append("-\n");
			
		}
		System.out.print(sb);
	}
}
