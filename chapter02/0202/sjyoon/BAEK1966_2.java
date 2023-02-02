package algo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BAEK1966_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 테스트케이스 개수
		int C = sc.nextInt();
		// 인쇄 횟수
		int cnt = 0;
		
		
		
		for (int i=0;i<C;i++) {
			// 문서의 개수, 대상문서
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 중요도 배열
			int[] impo = new int[N];
			
			// 입력 받은 중요도를 배열과 큐에 넣기
			for (int j=0;j<N;j++) {
				
				
				
				int doc = sc.nextInt();
				impo[j] = doc;		
				q.add(doc);
				
			}
			
			
			
			while (true) {
				Arrays.sort(impo);
				int max = impo[N];
				if (q.peek()==max) {
					q.poll();
					cnt++;
					impo[N] = 0;
				}else {
					q.add(q.poll());
				}
			}
			
			
			
		}
		
		sc.close();
	}	
}
