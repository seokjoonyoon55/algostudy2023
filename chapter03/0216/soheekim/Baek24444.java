package study0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek24444 {
	public static int vorder=1;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] firstline = bfr.readLine().split(" ");
		int N = Integer.parseInt(firstline[0]);
		int M = Integer.parseInt(firstline[1]);
		int R = Integer.parseInt(firstline[2]);
		
		String[]tempS=new String[2];

		int[][] line = new int[N][N];
		int[] node=new int[N];
		Queue<Integer> bfs = new LinkedList<Integer>();

		for (int i = 0; i < M; i++) {
			tempS= bfr.readLine().split(" ");
			line[Integer.parseInt(tempS[0])-1][Integer.parseInt(tempS[1])-1]=1;
			line[Integer.parseInt(tempS[1])-1][Integer.parseInt(tempS[0])-1]=1;
		}
		
		visit(line,  node, bfs, N,R-1);
		for(int i=0;i<N;i++) {
			System.out.println(node[i]);
		}
	}
	
	public static void visit(int[][] line, int [] node, Queue<Integer> bfs, int N, int R) {
		if(node[R]==0) {
			for(int i=0;i<N;i++) {
				if(line[R][i]==1&&node[i]==0) {
					bfs.add(i);
				}
			}
			
			node[R]=vorder++;
			
			if(bfs.isEmpty()) {
				while(node[R]!=0)
					R++;
				if(R<N) visit(line, node, bfs, N, R);
			}
			else {
				R=bfs.poll();
				visit(line, node, bfs, N, R);
			}
		}
		

	}
}
