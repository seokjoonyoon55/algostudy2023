package study0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2164 {
	public static void main(String[] args) throws IOException{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> quu = new LinkedList<>();//카드 저장할 큐
		boolean doRemove = true;//true면 제거 실행, false면 밑으로 옮기기 실행
		
		int N = Integer.parseInt(bfr.readLine());//카드 갯수 저장
		
		//1부터 N까지 순서대로 큐에 카드숫자 저장
		for(int i=1;i<=N;i++)
		{
			quu.add(i);
		}
		
		//quu가 2이상일 동안 실행
		while(quu.size()>1) {
			//deRemove 상태에 따라 true면 제거 실행, false면 밑으로 옮기기 실행
			if(doRemove) {
				quu.poll();
				doRemove=false;
				}
			else {
				quu.add(quu.poll());
				doRemove=true;
			}
		}
		//1개만 남았을 때 제일 위에꺼 출력
		System.out.println(quu.peek());
	}
}
