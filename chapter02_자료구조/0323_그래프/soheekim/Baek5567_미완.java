package study0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baek5567 {
	// static Stack<Integer> stk = new Stack<>();
	static int[] visitDepth;
	static List<Integer>[] linked;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bfr.readLine());
		int M = Integer.parseInt(bfr.readLine());

		String[] tempS = new String[2];
		int numL = -1;
		int numR = -1;

		visitDepth = new int[N + 1];

		// 연결리스트
		linked = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			linked[i] = new ArrayList<Integer>();
		}

		// 연결리스트에 간선 입력
		for (int i = 0; i < M; i++) {
			tempS = bfr.readLine().split(" ");
			numL = Integer.parseInt(tempS[0]);
			numR = Integer.parseInt(tempS[1]);

			linked[numL].add(numR);
			linked[numR].add(numL);
		}
	}

	public static void DFS2(int idx, int depth) {
		if (visitDepth[idx] != 0)
			return;

		visitDepth[idx] = depth;
		for (int i = 0; i < linked[idx].size(); i++) {
			DFS2(linked[idx].get(1),depth+1);
		}

	}

}
