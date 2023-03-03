package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK2164 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		// 1~N까지 큐에 넣기
		for (int i=1;i<=N;i++) {
			q.add(i);
		}
		
		// 버리고 옮기기. N-1번 실행
		for (int i=0;i<N-1;i++) {
			q.poll();
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
		sc.close();
	}
}
