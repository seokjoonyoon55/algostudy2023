package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEK2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());		
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		// size가 1보다 클 때 계속 반복
		while (q.size() > 1) {
			// 제일 위에 있는 카드 제거
			q.remove();
			// 제일 위에 있는 카드를 제일 아래로
			q.offer(q.poll());
		}
		
		System.out.println(q.peek());
		
		br.close();
	}
}
