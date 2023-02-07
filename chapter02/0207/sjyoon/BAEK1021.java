package algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BAEK1021 {
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for (int i=1;i<=N;i++) {
			dq.add(i);
		}
		
		// Integer[] arr = dq.toArray(new Integer[dq.size()]);
		
		// 연산할 때마다 발생하는 인덱스 변동을 적용시키기 위해 기록하는 변수
		int idx = 0;
		// 2,3번 연산 횟수
		int cnt = 0;
		
		
		for (int i=0;i<M;i++) {
			int num = sc.nextInt();
			
			// 뽑는 값이 맨 앞에 있을 때
			if (num==dq.peek()) {
				dq.poll();	
				idx--;
			} 
			// 뽑는 값의 위치가 덱 안에서 왼쪽(가운데)에 있을 때  => 2번 연산 사용
			else if (num-1+idx <= dq.size()/2+1) {
				while (dq.peek()!=num) {
					dq.add(dq.poll());
					idx--;
					cnt++;
				}
				dq.poll();
				idx--;
			}
			// 뽑는 값의 위치가 덱 안에서 오른쪽에 있을 때  => 3번 연산 사용
			else /*if (num+idx > dq.size()/2)*/ {
				while (dq.peek()!=num) {
					dq.addFirst(dq.pollLast());
					idx++;
					cnt++;
				}
				dq.poll();
				idx--;
			}
		}
		sc.close();
		
		System.out.println(cnt);
		
		
		// 1 2 3 4 5 6 7 8 9 10
		// 2 3 4 5 6 7 8 9 10
		// 7 8 9 10 2 3 4 5		4
		// 4 5 7 8 9 10 2		3
		// 4 5 7 8 9 10			1
		// 8 9 10 4 5			2
		// 10 4 5 8				1
		// 10 4 5				1
		// 5 10					1
		// 5					1
		// 
		
	}
}
