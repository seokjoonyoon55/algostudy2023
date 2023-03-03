package baekjoon_02_Silver;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int[] arr = new int[N];
		// arr의 인덱스 저장할 변수
		int index = 0;
		int num = 0;
		// arr[index]랑 일치하지 않는 숫자 임시 보관할 장소
		Stack<Integer> box = new Stack<>();
		// arr랑 같은 모양의 스택을 구현할 장소
		Stack<Integer> stack = new Stack<>();

		// 수열 만들기
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 4 3 6 8 7 5 2 1
		// box가 비어있으면 peep가 작동안하므로 0을 넣어줄 생각으로 0부터 시작
		// 어차피 주어지는 숫자는 1이상이라 했음
		while (true) {
			if (num == 0) {
				box.push(num);
				num++;
			} else {
				if (box.peek() == arr[index]) {
					stack.push(box.pop());
					index++;
					sb.append("-\n");
				} else {
					box.push(num);
					sb.append("+\n");
					num++;
				}
			}
			// stack이 완성되거나 box에 쌓이는 수중 가장 큰 수가 N(입력받은 수)보다 커지면 while문 종료
			if (stack.size() == arr.length || box.get(box.size() - 1) > N) {
				break;
			}
		}

		// 사이즈가 둘이 같으면 stack이 완성된 것 아니면 완성 안된 것
		if (stack.size() == arr.length) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}

}
