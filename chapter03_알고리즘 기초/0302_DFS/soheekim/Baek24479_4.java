package study0302;

import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek24479_4 {
	static int cntOrder = 1;//방문 순서

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader (new InputStreamReader(System.in));
		String[] NMR = bfr.readLine().split(" ");
		int N = Integer.parseInt(NMR[0]);//정점 갯수
		int M = Integer.parseInt(NMR[1]);//간선 갯수
		int R = Integer.parseInt(NMR[2]);//시작 정점 번호

		//임시변수들
		String[] tempS = new String[2];
		int tempA;
		int tempB;

		//간선 정보 저장용 연결리스트
		ArrayList<Integer>[] linked = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			linked[i] = new ArrayList<Integer>();
		}

		//방문여부 표기할 배열. 방문하면 방문순서 저장
		int[] visited = new int[N + 1];

		//간선 정보 저장
		for (int i = 0; i < M; i++) {
			tempS = bfr.readLine().split(" ");
			tempA = Integer.parseInt(tempS[0]);
			tempB = Integer.parseInt(tempS[1]);
			linked[tempA].add(tempB);
			linked[tempB].add(tempA);
		}

		//간선 정보 오름차순 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(linked[i]);
		}

		//DFS시작
		DFS(linked, visited, R);

		//방문순서 출력
		for (int i = 1; i < N + 1; i++) {
			System.out.println(visited[i]);
		}
	}

	//DFS 탐색 메서드
	public static void DFS(ArrayList<Integer>[] linked, int[] visited, int R) {
		//방문된 적이 없으면 방문순서 표시
		if (visited[R] == 0)
			visited[R] = cntOrder++;
		
		//연결된 간선 중 방문한 적 없는 간선에 대해 DFS 탐색
		for (int i = 0; i < linked[R].size(); i++) {
			if (visited[linked[R].get(i)] == 0)
				DFS(linked, visited, linked[R].get(i));
		}
	}
}