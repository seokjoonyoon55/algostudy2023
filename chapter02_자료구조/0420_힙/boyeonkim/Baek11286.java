import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		// 양수
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// 음수
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			// 0보다 큰 정수일 경우
			if (num > 0) {
				pq.add(num);
			// 0일 경우 큐에서 삭제
			} else if (num == 0) {
				// 양수 pq, 음수 pq 둘다 비어있지 않을 경우
				if(!pq.isEmpty() && !pq2.isEmpty()) {
					int a = pq.peek();
					int b = Math.abs(pq2.peek());
					// 절댓값 대소비교해서 삭제 후 출력
					if (a > b) {
						sb.append(pq2.remove()).append("\n");
					} else if (a == b) {
						sb.append(pq2.remove()).append("\n");
					} else {
						sb.append(pq.remove()).append("\n");
					}
				// 음수 pq만 남아있을 경우
				} else if(pq.isEmpty() && !pq2.isEmpty()) {
					sb.append(pq2.remove()).append("\n");
				// 양수 pq만 남아있을 경우
				} else if(!pq.isEmpty() && pq2.isEmpty()){
					sb.append(pq.remove()).append("\n");
				// 둘 다 비어있을 경우
				} else if(pq.isEmpty() && pq2.isEmpty()) {
					sb.append(0).append("\n");
				}
			// 음수일 경우
			} else pq2.add(num);
		}
		System.out.println(sb);
	}
}
