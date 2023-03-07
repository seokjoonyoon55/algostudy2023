package study0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> quu = new LinkedList<>(); //숫자 저장 큐
		StringBuffer sb = new StringBuffer();
		
		
		String[] nk = bfr.readLine().split(" ");
		int N=Integer.parseInt(nk[0]);//N명 사람
		int K=Integer.parseInt(nk[1]);//K번째 삭제
		
		int count=0;//K까지 수 세서 저장할 변수
		
		//1부터 N까지 큐에 넣기
		for(int i=1;i<=N;i++) {
			quu.add(i);
		}
		
		//큐가 2이상일 동안 반복
		while(quu.size()>1) {
			count++;//카운트 초기값은 0, 세는 순간 1추가
			if(count!=K) {
				quu.add(quu.poll());//센지 K번째가 아니면 큐에서 빼서 뒤에 넣음
			}
			else {
				sb.append(quu.poll()+", ");//센지 K번째이면 큐에서 빼고 스트링버퍼에 넣고
				count=0;//카운트 초기화시킴
			}
		}
		//1개이면 while문이 실행되지 않으므로 마지막 수는 큐에 남아있음
		
		//마지막 남은 수 큐에서 빼서 스트링버퍼에 붙이고 출력
		sb.append(quu.poll());
		System.out.println("<"+sb+">");
	}
}
