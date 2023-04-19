import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1927_최소힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// 오름차순 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			// 0이라면 값 제거
			if(num == 0) {
				// 비어있다면 0출력
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				// 비어있지 않다면 값 출력
				} else {
					sb.append(pq.remove()).append("\n");
				}
			// 0 이상의 정수라면 큐에 값 추가
			} else if(num > 0) {
				pq.add(num);
			}
		}
		System.out.println(sb);
	}
}
