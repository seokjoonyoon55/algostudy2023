package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//크루스칼 사용
public class Baek17472_2 {
	// 간선 클래스
	static class Edge implements Comparable<Edge> {
		int from, to, length;

		public Edge(int from, int to, int length) {
			super();
			this.from = from;
			this.to = to;
			this.length = length;
		}

		@Override
		public String toString() {
			return "[from " + from + " to " + to + ", " + length + "]";
		}

		// 길이 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return this.length - o.length;
		}
	}

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int R, C;// 행, 열
	static int island = 2;// 부여할 섬 번호. 2번부터 부여
	static int[][] field;// 섬 상태
	static int[] group;// 그룹 대표자 저장 배열

	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = bfr.readLine().split(" ");

		R = Integer.parseInt(RC[0]);// 행
		C = Integer.parseInt(RC[1]);// 열

		field = new int[R][C];// 섬 상태

		// 지도 입력받기
		String[] tempS;
		for (int r = 0; r < R; r++) {
			tempS = bfr.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				field[r][c] = Integer.parseInt(tempS[c]);
			}
		}

		// 모든 칸에 대해
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 아직 발견되지 않은 섬이라면
				if (field[r][c] == 1) {
					// dfs 돌면서 연결된 칸에 전부 섬 번호 붙이기
					dfs(r, c);

					// 붙일 섬번호++. 섬번호는 2번부터 시작
					island++;
				}
			}
		}

		// 모든 칸에 대해 다리 찾기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 섬이라면 다리 찾는 메서드 실행
				if (field[r][c] != 0) {
					buildBridge(r, c);
				}
			}
		}

		// for union find
		group = new int[island];

		// 대표자 자기자신 입력
		for (int i = 2; i < island; i++) {
			group[i] = i;
		}

		int select = 0;// 선택된 간선 수
		int sumBridge = 0;// 합해진 다리 길이

		// 우선순위 큐가 빌 때까지 반복
		while (!pq.isEmpty()) {
			// 간선 수 == 정점 수 -1되면 반복 종료
			if (select == island - 2)
				break;

			// 간선 하나 꺼내기
			Edge tempE = pq.poll();

			// 시작점, 끝점이 이미 같은 그룹으로 묶여있으면 continue;
			if (find(tempE.from) == find(tempE.to))
				continue;
			// 시작점, 끝점이 다른 그룹이라면 합치기
			else
				union(tempE.from, tempE.to);

			// 다리 길이 합에 간선길이 저장
			sumBridge += tempE.length;

			// 선택 수++
			select++;

		}

		// 선택된 간선이 있고, 선택된 간선수 == 전체 간선 수이면 출력
		if (select != 0 && select == island - 3)
			System.out.println(sumBridge);
		// 선택된 간선 수가 모자라면 -1출력
		else
			System.out.println(-1);

	}

	// 연결된 땅에 섬번호 입력하는 dfs
	private static void dfs(int r, int c) {
		// 1 : 번호 부여되지 않은 땅
		// 섬 번호 부여
		if (field[r][c] == 1)
			field[r][c] = island;

		// 4방에 대해
		for (int dir = 0; dir < 4; dir++) {
			// 경계조건
			if (r + dr[dir] < 0 || r + dr[dir] >= R || c + dc[dir] < 0 || c + dc[dir] >= C)
				continue;

			// 다음칸 1일 경우 dfs
			if (field[r + dr[dir]][c + dc[dir]] == 1)
				dfs(r + dr[dir], c + dc[dir]);
		}
	}

	// 간선 찾는 메서드
	private static void buildBridge(int r, int c) {
		int curr = r;// 현재 행
		int curc = c;// 현재 열
		int cnt0 = 0;// 0 카운트 = 다리 길이
		boolean isBridge = true;// 다리 완성되었는지 여부

		// 4방에 대해
		for (int dir = 1; dir < 3; dir++) {
			// 위치, 상태 초기화
			curr = r;
			curc = c;
			cnt0 = 0;
			isBridge = true;

			while (true) {
				// 경계조건
				if (curr + dr[dir] < 0 || curr + dr[dir] >= R || curc + dc[dir] < 0 || curc + dc[dir] >= C) {
					isBridge = false;
					break;
				}

				// 같은 섬일경우 종료
				if (field[r][c] == field[curr + dr[dir]][curc + dc[dir]]) {
					isBridge = false;
					break;
				}

				// 0이 아닐 경우 반복 종료
				if (field[curr + dr[dir]][curc + dc[dir]] != 0)
					break;

				curr = curr + dr[dir];
				curc = curc + dc[dir];
				cnt0++;

			}
			// while문 종료는 3가지. 경계조건이라 다리X, 같은 섬이라 다리X, 다른섬 만나서 다리O

			// 다리 완성됐고 길이가 2이상이면 우선큐에 넣음
			if (isBridge && cnt0 > 1) {
				pq.add(new Edge(field[r][c], field[curr + dr[dir]][curc + dc[dir]], cnt0));
			}

		}
	}

	// 그룹 대표자 찾는 메서드
	private static int find(int idx) {
		if (group[idx] != idx)
			group[idx] = find(group[idx]);
		return group[idx];
	}

	// 그룹 합치기 메서드
	private static void union(int idx1, int idx2) {
		if (idx1 > idx2)
			group[find(idx1)] = find(idx2);
		else
			group[find(idx2)] = find(idx1);
	}

	// 출력테스트용
	private static void print() {
		for (int r = 0; r < R; r++) {
			System.out.println(Arrays.toString(field[r]));
		}
		System.out.println();
	}
}
