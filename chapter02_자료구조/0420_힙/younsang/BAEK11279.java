package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BAEK11279 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		// 큰 값이 먼저 poll되는 우선순위 큐 선언 및 초기화
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				// 0일 때 큐에 아무것도 안담겨 있으면 그냥 0 출력
				if (pq.size() == 0) sb.append(0).append("\n");
				// 큐에 담겨져있으면 poll한 값(제일 큰 값) 출력
				else sb.append(pq.poll()).append("\n");
			// 큐에 담기
			} else pq.add(x);
		}
		System.out.println(sb.toString());
	}
}
