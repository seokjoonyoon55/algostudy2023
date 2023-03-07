package algorithm;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			int num = sc.nextInt();
			if(num == 0) { // 입력 숫자가 0 일때
				if(!st.isEmpty()) { // 스택이 비어있지 않다면
					st.pop(); // 숫자 제거
				}
				else
					continue; // 비어있다면 continue
			}
			else { // 입력숫자가 0이 아니라면
				st.push(num); // 입력한 숫자 넣기
			}
		}
		while(!st.isEmpty()) { // 스택이 빌때까지
			sum+=st.pop(); // 스택에있는 수 빼서 sum에 값 더하기
		}
		System.out.println(sum);
	}
}
