package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK11866 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력값 선언
		String in = sc.nextLine();		
		int N = Integer.parseInt(in.split(" ")[0]);
		int K = Integer.parseInt(in.split(" ")[1]);
		
		// 처음에 큐에 모든 숫자 집어넣기
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i =1;i<=N;i++) {
			q.add(i);
		}
			
		// 제거하는 값 넣을 스트링빌더
		StringBuilder sb = new StringBuilder();
		
		// add(poll) * (K-1) + poll
		// 마지막은 poll만 해도 되기 때문에 출력 따로 하려고 뺐음.
		for (int i=0;i<N-1;i++) {
			for (int j=0;j<K-1;j++) {
				q.add(q.poll());
			}
			sb.append((q.poll())+", ");
		}
		
		System.out.println("<"+sb+q.poll()+">");
		sc.close();
	}
}
