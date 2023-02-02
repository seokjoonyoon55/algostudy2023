package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.StringTokenizer;


public class BAEK18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// command (입력값)
		String com;
		// back 명령 수행을 위해 큐에 숫자를 넣을 때마다 그 값을 last로 지정
		int last = -1;
		
		
		for (int i=0;i<N;i++) {
			
			//StringTokenizer st = new StringTokenizer(br.readLine());
			//com = st.nextToken();
			com = br.readLine();
			
					
			if (com.equals("size")) {
				System.out.println(q.size());
			}
			else if (com.equals("empty")) {
				if (q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if (com.equals("pop")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
			}
			else if (com.equals("front")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
			}
			else if (com.equals("back")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(last);
			}
			else {
				last = Integer.parseInt(com.split(" ")[1]);
				q.add(last);
				//System.out.println(last);
			}
				
			
			/*
			if (com.contains("push")) {
				last = Integer.parseInt(com.split(" ")[1]);
				q.add(last);
			}
			else if (com.equals("size")) {
				System.out.println(q.size());
			}
			else if (q.isEmpty()) {
				if (com.equals("empty")) System.out.println(1);
				else System.out.println(-1);
			} else {
				if (com.equals("empty")) System.out.println(0);
				else if (com.equals("pop")) System.out.println(q.poll());
				else if (com.equals("front")) System.out.println(q.peek());
				else System.out.println(last);
			}
			
			*/
			
			
			
		}
		
		
		br.close();
	}
}
