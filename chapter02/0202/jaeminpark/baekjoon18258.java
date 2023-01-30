package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 그냥 Queue로 하니까 안됨
		Deque<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		// 명령어
		String order;

		// 실행할 명령어의 개수
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 스캐너로 명령어 불러오기
			order = st.nextToken();

			// order가 push 라면
			if (order.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
				
			// order가 pop 이라면
			} else if (order.equals("pop")) {
				if(queue.size() == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
				
			// order가 size 라면
			} else if (order.equals("size")) {
				sb.append(queue.size()).append("\n");
				
			// order가 empty 라면
			} else if (order.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				
			// order가 front 라면
			} else if (order.equals("front")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peekFirst()).append("\n");
				}
				
			// order가 back 이라면
			} else if (order.equals("back")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peekLast()).append("\n");
				}

			}

		}
		
		// 출력
		System.out.println(sb);
	}

}
