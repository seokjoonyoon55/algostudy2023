package study0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek18258 {
	public static void main(String[] args) throws IOException{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> quu = new LinkedList<>();
		boolean doRemove = true;
		
		int N = Integer.parseInt(bfr.readLine());
		
		for(int i=1;i<=N;i++)
		{
			quu.add(i);
		}
		
		while(quu.size()>1) {
			if(doRemove) {
				quu.poll();
				doRemove=false;
				}
			else {
				quu.add(quu.poll());
				doRemove=true;
			}
		}
		
		System.out.println(quu.peek());
	}
}
