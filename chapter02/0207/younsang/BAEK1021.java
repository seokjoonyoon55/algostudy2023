package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BAEK1021 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	static LinkedList<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		// 뽑아내려고 하는 수의 위치
		int[] temp = new int[M];
		for(int i = 0 ; i < M ; i++)
			temp[i] = Integer.parseInt(st.nextToken());
		
		// 큐의 크기만큼 1부터 순서대로 삽입
		for(int i = 1 ; i <= N ; i++)
			q.add(i);
		
		for(int i = 0 ; i < M ; i++) {
			// check method에서 true를 반환하므로 앞에 원소들을 뒤로 계속 보내는 작업
			if(check(temp[i])) {
				while(temp[i]!=q.get(0)) {
				q.addLast(q.pollFirst());
				count++;
				}
			// check method에서 false를 반환하므로 뒤에 원소들을 앞으로 계속 보내는 작업
			}else {
				while(temp[i]!=q.get(0)) {
				q.addFirst(q.pollLast());
				count++;
				}
			}
			q.poll();
		}
		System.out.println(count);
	}
	public static boolean check(int a) {
		// 큐의 크기에서 절반보다 앞에 있으면 true return
		// 뒤에 있으면 false return.
		for(int i = 0 ; i <= q.size()/2 ; i++) {
			if(a == q.get(i))
				return true;
		}
		return false;
	}
}
