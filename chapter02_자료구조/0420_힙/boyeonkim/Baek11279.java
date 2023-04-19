import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// 내림차순 정렬
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		// N : 연산의 갯수
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 배열에 값 넣어주는 연산
			if(num > 0) {
				q.add(num);
				
			// 배열에서 가장 큰 값 출력하고 그 값을 배열에서 제거
			} else if(num == 0) {
				if(q.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(q.remove()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
