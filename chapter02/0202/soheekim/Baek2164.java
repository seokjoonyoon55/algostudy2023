package study0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> quu = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		
		String[] nk = bfr.readLine().split(" ");
		int N=Integer.parseInt(nk[0]);
		int K=Integer.parseInt(nk[1]);
		
		int count=0;
		
		for(int i=1;i<=N;i++) {
			quu.add(i);
		}
		
		while(quu.size()>1) {
			count++;
			if(count!=K) {
				quu.add(quu.poll());
			}
			else {
				sb.append(quu.poll()+", ");
				count=0;
			}
		}
		
		//마지막 남은 수 스트링버퍼에 붙이고 출력
		sb.append(quu.poll());
		System.out.println("<"+sb+">");
	}
}
