package study0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek24479 {
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
		Queue<Integer> dfs = new LinkedList<Integer>();

		for (int i = 0; i < M; i++) {
			tempS= bfr.readLine().split(" ");
			line[Integer.parseInt(tempS[0])-1][Integer.parseInt(tempS[1])-1]=1;
			line[Integer.parseInt(tempS[1])-1][Integer.parseInt(tempS[0])-1]=1;
		}
		
		visit(line,  node, dfs, N,R-1);
		
		
	}
	
	public static void visit(int[][] line, int [] node, Queue<Integer> dfs, int N, int R) {
		for(int i=0;i<N;i++) {
			if(line[R][i]==1) dfs.add(i);
		}
		
		node[R]=vorder++;
		System.out.println(R);
		
		if(dfs.isEmpty()) {
			while(node[R]!=0)
				R++;
			if(R<N) visit(line, node, dfs, N, R);
		}
		else {
			R=dfs.poll();
			visit(line, node, dfs, N, R);
		}
	}
}
