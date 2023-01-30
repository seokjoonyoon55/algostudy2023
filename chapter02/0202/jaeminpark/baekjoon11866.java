package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon11866 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		//출력 형식 맞추기 위함
		sb.append("<");
		// K는 N 이하
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 사람을 몇번 제거했는지 카운트할 변수
		int kCnt;
		Deque<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		boolean flag = true;
		
		while (flag) {

			// 앞에 애들 뒤에다 붙이기
			for (int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			
			// K번째 사람 제거하기
			if(q.size() == 1) {
				// 마지막엔 쉼표 안붙음
				sb.append(q.poll());
			} else {
				// 출력 형식 맞추기 위함
				sb.append(q.poll()).append(", ");
			}
			
			// q가 빈다면 while문 탈출
			if(q.isEmpty()) {
				flag = false;
			}
		}
		// 출력 형식 맞추기 위함
		sb.append(">");
		
		// 출력
		System.out.println(sb);
	}
}
