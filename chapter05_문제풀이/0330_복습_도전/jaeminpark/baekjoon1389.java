package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon1389 {

	// 유저 수
	static int N;
	// 관계 수
	static int M;
	// 유저들 배열
	static int[] people;
	// 각 유저가 갖고 있는 관계들로 만든 리스트 배열
	static List<Integer>[] relationships;
	// 케빈 베이컨 게임 돌릴 배열
	static int[] visited;
	// 가장 작은 케빈 베이컨의 수
	static int minCnt = Integer.MAX_VALUE;
	// 다 같을 경우 1 가장 번호가 작은 사람 출력해야 하므로 1로 초기화(상관없음)
	static int minIndex = 1;
	// 케빈 베이컨 게임 시작할 사람의 번호 저장할 배열
	static int start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new int[N + 1];
		relationships = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			relationships[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			relationships[p1].add(p2);
			relationships[p2].add(p1);
		}
		/////////////////////////////////// 여기까지 초기화 및 입력 받아서 만들기 세팅

		// 1번부터 N번 유저 각 경우 따지기
		for (int i = 1; i <= N; i++) {
			// 해당 유저 start에 저장(minCnt 갱신할 경우 minIndex에 해당 유저 번호 저장하기 위함)
			start = i;
			// kb 들어갈때마다 visited 배열은 초기화 해줘야 함
			visited = new int[N + 1];
			// bfs? dfs? 시작
			kb(i, 0);
		}
		System.out.println(minIndex);
	}

	private static void kb(int from, int cnt) {
		// from은 관계의 시발점
		// cnt는 관계 몇번 지나왔는지 저장하는 변수
		boolean allVisited = true;
		for (int i = 1; i <= N; i++) {
			// visited[start] = 0 무조건 0 이므로 스킵
			if (i == start)
				continue;
			// 그 외 visited[i] 가 0일 경우 모든 경우를 돈 것이 아니므로 for문 탈출 후 다음 진행
			if (visited[i] == 0) {
				allVisited = false;
				break;
			}
		}

		if (allVisited) {
			// 마지막에 갱신 될 수도 있네
			for (int i = 0; i < relationships[from].size(); i++) {
				if (relationships[from].get(i) == start)
					continue;
				if (visited[relationships[from].get(i)] > cnt + 1) { // 이 경우에 갱신될 수도 있음
					visited[relationships[from].get(i)] = cnt + 1;
				}
			}
			int fCnt = 0;
			for (int i = 1; i <= N; i++) {
				fCnt += visited[i];
			}
			// minCnt가 갱신된다면 minIndex도 갱신
			if (fCnt < minCnt) {
				minCnt = fCnt;
				minIndex = start;
			}
			return;
		}

		for (int i = 0; i < relationships[from].size(); i++) {
			if (relationships[from].get(i) == start)
				continue;
			if (visited[relationships[from].get(i)] == 0) {
				visited[relationships[from].get(i)] = cnt + 1;
				kb(relationships[from].get(i), cnt + 1);
			} else {
				if (visited[relationships[from].get(i)] > cnt + 1) {
					visited[relationships[from].get(i)] = cnt + 1;
					kb(relationships[from].get(i), cnt + 1);
				}
			}
		}
	}

}
