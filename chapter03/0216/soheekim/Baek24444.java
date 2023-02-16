package study0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//메모리 초과
public class Baek24444 {
	public static int vorder=1;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] firstline = bfr.readLine().split(" ");
		int N = Integer.parseInt(firstline[0]);
		int M = Integer.parseInt(firstline[1]);
		int R = Integer.parseInt(firstline[2]);
		
		String[]tempS=new String[2];

		int[][] line = new int[N][N];//간선 저장할 2차원 배열
		int[] node=new int[N];//방문순서 저장할 배열
		Queue<Integer> bfs = new LinkedList<Integer>();//bfs구현을 위한 큐

		//간선 표시
		for (int i = 0; i < M; i++) {
			tempS= bfr.readLine().split(" ");
			line[Integer.parseInt(tempS[0])-1][Integer.parseInt(tempS[1])-1]=1;
			line[Integer.parseInt(tempS[1])-1][Integer.parseInt(tempS[0])-1]=1;
		}
		
		visit(line,  node, bfs, N,R-1);//탐색 시작
		//결과 출력
		for(int i=0;i<N;i++) {
			System.out.println(node[i]);
		}
	}
	
	//탐색 메서드
	public static void visit(int[][] line, int [] node, Queue<Integer> bfs, int N, int R) {
		//노드 방문한 적이 없으면
		if(node[R]==0) {
			//연결된 간선 탐색해서
			for(int i=0;i<N;i++) {
				//연결된 간선이 방문된 적 없으면 큐에 저장
				if(line[R][i]==1&&node[i]==0) {
					bfs.add(i);
				}
			}
			
			node[R]=vorder++;//방문순서 저장
			
			//큐가 비어있으면
			if(bfs.isEmpty()) {
				while(node[R]!=0)
					R++;
				if(R<N) visit(line, node, bfs, N, R);
			}
			//비어있지 않으면
			else {
				R=bfs.poll();
				visit(line, node, bfs, N, R);
			}
		}
		

	}
}
