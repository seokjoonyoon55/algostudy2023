package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class BAEK4949 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Loop:
		while (true) {
			
			String s = br.readLine();
			
			// 마지막 줄 "." 반복문 끝내기
			if (s.equals(".")) break;
			
			String[] arr = s.split("");
			Stack<String> stk = new Stack<>();
			
		
			for (String a : arr) {
				
				// "(" 이거나 "[" 이면 스택에 넣고, ")"이거나 "]" 이면 스택pop이 짝인지 확인
				// 짝 맞으면 다음으로 넘어가고, 안맞으면 "no" 출력 후 다음 Loop 으로
				try {
					if (a.equals("(") || a.equals("[")) {
						stk.push(a);
					} else if (a.equals(")")) {
						if (!stk.pop().equals("(")) {
							System.out.println("no");
							continue Loop;
						}
					} else if (a.equals("]")) {
						if (!stk.pop().equals("[")) {
							System.out.println("no");
							continue Loop;
						}
					}
				
				// EmptyStackException 발생 시 이미 ()[] 짝이 안맞는 것이므로 "no" 출력
				// 배열의 요소들을 더 이상 확인할 필요 없으므로 다음 Loop으로 이동
				} catch (EmptyStackException e) {
					System.out.println("no");
					continue Loop;
				} 
					
				
			}
			
			// 예외 없이 for문 돌고나서 스택이 비어있으면 "yes"
			if (stk.empty()) {
				System.out.println("yes");
			} else System.out.println("no");
			
		}
		
		br.close();
	}
}
