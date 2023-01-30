package study0130;

import java.util.Scanner;
import java.util.Stack;

//스택 쓰고 푼 것
public class Baek9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 갯수
		
		Stack<Character> st = new Stack<Character>();// (와 )를 저장할 스택

		String indata;//문자열 읽어서 저장할 임시 변수

		for (int tc = 0; tc < T; tc++) {
			st.clear();
			indata = sc.next(); //문자열 읽어옴
			//문자열 길이만큼 반복
			for (int i = 0; i < indata.length(); i++) {
				// (이면 스택에 push
				if (indata.charAt(i) == '(') {
					st.push('(');
				}
				
				else {
					// )이면 비었을 때 넣고 반복문 탈출,
					if (st.size() == 0)
					{
						st.push(')');
						break;
					}
					// 안 비었을 때 (를 pop. 비어있지 않다면 존재하는 요소는 무조건 (니까.
					else {
						st.pop();
					}
				}
			}
			//VPS면 무조건 size==0. 0이 아니라면 끝까지 했는데 남아있거나, 중간 탈출해서 )넣어져 있거나 기 때문에.
			if (st.size()==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
