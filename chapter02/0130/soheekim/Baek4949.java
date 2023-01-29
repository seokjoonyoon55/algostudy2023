package study0130;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baek4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		Stack<String> st = new Stack<>();

		boolean onlydot = false;
		String sentence = "";

		while (!onlydot) {
			// 문장 받기
			sentence = bfr.readLine();
			if (sentence.length() > 102)
				sentence = sentence.substring(0, 101);
			// .만 있으면 반복문 종료
			if (sentence.equals(".")) {
				onlydot = true;
				break;
			} else {
				for (int i = 0; i < sentence.length(); i++) {
					if (sentence.charAt(i) == '(')
						st.push("(");
					else if (sentence.charAt(i) == '[')
						st.push("[");
					else if (sentence.charAt(i) == ')') {
						if (st.size() != 0 && st.peek().equals("(")) {
							st.pop();
						} else {
							st.push(")");
							break;
						}
					} else if (sentence.charAt(i) == ']') {
						if (st.size() != 0 && st.peek().equals("["))
							st.pop();
						else {
							st.push("]");
							break;
						}
					}
				}
			}

			if (st.size() == 0)
				System.out.println("yes");
			else
				System.out.println("no");

			st.clear();
		}
	}
}
