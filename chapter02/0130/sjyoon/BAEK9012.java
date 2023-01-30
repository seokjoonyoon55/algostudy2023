package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class BAEK9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Loop:
		for (int i=0; i<T; i++) {
			Stack<String> stk = new Stack<>();
			String ps = br.readLine();
			String[] arr = ps.split("");
		
			
			// "(" 이면 스택에 넣고, ")"이면 스택에 있는 "(" 제거
			for (String p : arr) {
					
				try {
					if (p.equals("(")) {
						stk.push(p);
					} else {
						stk.pop();
					}
					
				// EmptyStackException 발생 시 이미 () 짝이 안맞는 것이므로 "NO" 출력	
				// 배열의 요소들을 더 이상 확인할 필요 없으므로 다음 Loop으로 이동
				} catch (EmptyStackException e) {
					System.out.println("NO");
					continue Loop;
				} 

			}
			
			// 예외 없이 for문 돌고나서 스택이 비어있으면 "YES"
			if (stk.empty()) {
				System.out.println("YES");
			} else System.out.println("NO");
			
		}
		
		br.close();
	}
}
