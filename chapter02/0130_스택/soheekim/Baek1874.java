package study0130;

import java.util.Scanner;
import java.util.Stack;
//메모리초과로 실패뜸
//아마 문자열 뒤에 더할때마다 새 문자열 만들어서 옮겨서 인 것 같음
public class Baek1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//수 담아놓을 스택
		Stack<Integer> st = new Stack<>();

		int n = sc.nextInt();//수 갯수 받음
		
		int num = 1; //현재 다루는 숫자
		int[] in = new int[n];//입력 저장 배열
		int pointer = 0;//입력 저장 배열 인덱스
		
		String action = "";//+ - 저장할 문자열
		int noif1 = 0;//1이면 NO출력, 0이면 +-문자열 출력

		//n개 입력 받아서 배열에 저장
		for (int i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}

		do {
			//스택이 비었으면 일단 숫자 넣고 +, 다음 숫자
			if (st.size() == 0) {
				st.push(num);
				action += "+";
				num++;
			}
			
			//스택이 안비었으면
			else {
				//스택 맨 뒤랑 현재 입력이랑 비교해서 
				//맨 뒤가 더 작으면 다루는 수 push, +, 다음 숫자 다루기
				if (st.peek() < in[pointer]) {
					st.push(num);
					action += "+";
					num++;
				}
				//맨 뒤 = 현재 입력 이면 맨 뒤 pop, -, 다음 입력 비교하기
				else if (st.peek() == in[pointer]) {
					st.pop();
					action += "-";
					pointer++;
				}
				//맨 뒤가 더 크면 더이상 할 수 있는 액션이 없으므로 이후 NO출력을 위해 noif1을 1로 만듦;
				else if (st.peek() > in[pointer]) {
					noif1 = 1;
					break;
				}
			}

		} while (!(st.size() == 0 && pointer == n));
		//스택이 비어있지 않고, 입력 저장 배열이 끝이 아니면 계속 반복
		//첫 시작은 무조건 스택이 비어있으므로 do while문
		
		if (noif1 == 0) {
			for (int i = 0; i < action.length(); i++) {
				System.out.println(action.charAt(i));
			}
		}
		else System.out.println("NO");
		sc.close();
	}
}
