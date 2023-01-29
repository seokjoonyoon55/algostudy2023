package study0130;

import java.util.Scanner;
import java.util.Stack;
//메모리초과로 실패뜸
public class Baek1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> st = new Stack<>();
		String action = "";
		int pointer = 0;

		int n = sc.nextInt();
		int num = 1;
		int[] in = new int[n];
		int noif1 = 0;

		for (int i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}

		do {
			if (st.size() == 0) {
				st.push(num);
				action += "+";
				num++;
			}

			else {
				if (st.peek() < in[pointer]) {
					st.push(num);
					action += "+";
					num++;
				} else if (st.peek() == in[pointer]) {
					st.pop();
					action += "-";
					pointer++;
				} else if (st.peek() > in[pointer]) {
					System.out.println("NO");
					noif1 = 1;
					break;
				}
			}

		} while (!(st.size() == 0 && pointer == n));

		if (noif1 == 0) {
			for (int i = 0; i < action.length(); i++) {
				System.out.println(action.charAt(i));
			}
		}
		sc.close();
	}
}
