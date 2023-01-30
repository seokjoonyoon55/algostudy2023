package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class baekjoon2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// BR로 N(카드개수) 받아오기
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		// q에 카드 숫자 넣기
		for(int i = 1; i<=N; i++) {
			q.offer(i);
		}
		
		boolean flag = true;
		
		// 1일때 조건 안달면 1 입력하면 null 나옴
		if(N == 1) {
			System.out.println("1");
		} else {
			while (flag) {
				// 맨 앞(head) 카드 버리기
				q.remove();
				
				// 맨 뒤(rear)에 맨 앞(head)카드 놓기
				q.offer(q.poll());
				
				// q의 사이즈가 1개가 된다면 루프 종료
				if (q.size() == 1) {
					flag = false;
				}
			}
			
			// 출력
			System.out.println(q.poll());
		}
	}
}
