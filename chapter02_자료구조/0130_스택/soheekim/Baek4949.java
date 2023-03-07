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

			// 길이가 과하게 길어지면 잘라서 저장하기
			if (sentence.length() > 102)
				sentence = sentence.substring(0, 101);

			// .만 있으면 반복문 종료
			if (sentence.equals(".")) {
				onlydot = true;
				break;
			} else {
				for (int i = 0; i < sentence.length(); i++) {
					// (와 [는 무조건 push
					if (sentence.charAt(i) == '(')
						st.push("(");
					else if (sentence.charAt(i) == '[')
						st.push("[");
					// )와 ]는 스택이 비어있지 않고 맨 위가 짝을 이루면 짝 이루는 걸 pop 으로 제거.
					// 비어있으면거나 짝을 이루지 않으면 반드시 불균형이므로 넣고 반복문 탈출. size를 0이 아니게 만들기 위해 넣음.
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
				} //문자열 탐색하는 반복문
			}//1개 케이스 탐색 끝

			//size가 0일 경우는 짝을 이뤘을 때 뿐.
			if (st.size() == 0)
				System.out.println("yes");
			//중간에 탈출해도 안맞는 짝을 넣고 탈출하기 때문에 불균형이면 무조건 size != 0
			else
				System.out.println("no");

			st.clear();
		}
	}
}
