package study0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek5567 {

	static int[] visited;// 방문여부 저장
	static Queue<Integer> quu = new LinkedList();// BFS용 큐
	static List<Integer>[] linked;// 연결
	static int cnt = 0;// 초대 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		// N 노드 수 , M간선 수
		int N = Integer.parseInt(bfr.readLine());
		int M = Integer.parseInt(bfr.readLine());

		// 입력 받기용 임시 변수들
		String[] tempS = new String[2];
		int numL = -1;
		int numR = -1;

		// 방문여부 저장배열 할당. 편의상 0번인덱스 사용X
		visited = new int[N + 1];

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

		// 탐색시작점 표시 후 BFS시작
		visited[1] = 1;
		quu.add(1);
		while (quu.size() != 0)
			BFS2(quu.poll());

		// 출력
		System.out.println(cnt);

	}

	// 깊이2까지만 탐색하는 BFS
	public static void BFS2(int idx) {

		// 깊이가 2이상이면 종료
		if (visited[idx] > 3)
			return;

		// 연결된 간선들에 대해
		for (int i = 0; i < linked[idx].size(); i++) {
			// 다음 노드 후보
			int next = linked[idx].get(i);

			// 다음 노드 후보가 방문되지 않았으면
			if (visited[next] == 0) {
				//다음노드 표시 후 큐에 넣음
				visited[next] = visited[idx] + 1;
				quu.add(next);
				
				//너비가 3이하라면 cnt++
				if (visited[next] < 4)
					cnt++;
				
			}
		}
	}

}
