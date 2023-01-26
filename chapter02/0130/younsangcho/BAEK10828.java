package algorithm_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BAEK10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			// push X일 경우
			if (str.contains("push")) {
				// 공백기준으로 문자열 나눠서 저장
				String[] arr = str.split(" ");
				stack.push(Integer.parseInt(arr[1]));
			// pop일 경우
			} else if (str.equals("pop")) {
				if (stack.size() == 0) System.out.println(-1);
				else {
					System.out.println(stack.peek());
					stack.pop();
				}
			// size일 경우
			} else if (str.equals("size")) {
				System.out.println(stack.size());
			// top일 경우
			} else if (str.equals("top")) {
				if (stack.size() == 0) System.out.println(-1);
				else {
					System.out.println(stack.peek());
				}
			// empty일 경우
			} else {
				if (stack.size() == 0) System.out.println(1);
				else System.out.println(0);
			}
		}
	}
}
