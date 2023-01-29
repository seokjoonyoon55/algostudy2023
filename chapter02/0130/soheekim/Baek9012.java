package study0130;

import java.util.Scanner;
import java.util.Stack;

public class Baek9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Character> st = new Stack<Character>();

		String indata;

		for (int tc = 0; tc < T; tc++) {
			st.clear();
			indata = sc.next();
			for (int i = 0; i < indata.length(); i++) {
				if (indata.charAt(i) == '(') {
					st.push('(');
				} else {
					if (st.size() == 0)
					{
						st.push(')');
						break;
					}
					else {
						st.pop();
					}
				}
			}
			if (st.size()==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
