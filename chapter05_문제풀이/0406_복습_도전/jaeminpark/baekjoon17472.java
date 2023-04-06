package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon17472 {

	static class line implements Comparable<line> {
		int to;
		int distance;

		line(int to, int distance) {
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(line o) {
			return distance - o.distance;
		}

	}

	static class Coordinate {
		int r;
		int c;

		Coordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬에 붙일 번호
		int islandNum = 0;
		// bfs 돌릴 Queue
		Queue<Coordinate> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		// 각 섬에 번호 붙이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					// 섬을 만나면 islandNum 하나 증가시키고 그 섬에 번호 붙이기
					islandNum++;
					map[i][j] = islandNum;
					q.offer(new Coordinate(i, j));
					// bfs 돌면서 해당 섬과 이어져있는 섬에 다 같은 번호 붙이기
					while (!q.isEmpty()) {
						Coordinate x = q.remove();
						int I = x.r;
						int J = x.c;
						for (int k = 0; k < 4; k++) {
							int nI = I + dx[k];
							int nJ = J + dy[k];
							if (nI < 0 || nI >= N || nJ < 0 || nJ >= M || visited[nI][nJ] || map[nI][nJ] == 0)
								continue;
							visited[nI][nJ] = true;
							map[nI][nJ] = islandNum;
							q.offer(new Coordinate(nI, nJ));
						}
					}
				}
			}
		}
		// 인접리스트
		List<line>[] lines = new ArrayList[islandNum + 1];
		// 인접리스트 초기화
		for (int i = 1; i <= islandNum; i++) {
			lines[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int num = map[i][j];
					// 상 체크
					int iFrom = i - 1;
					if (iFrom < 0)
						iFrom = 0;
					int iTo = 0;
					for (int r = iFrom; r >= iTo; r--) {
						if (map[r][j] == num)
							break;
						if (map[r][j] != 0) {
							int to = map[r][j];
							int distance = i - r - 1;
							if (distance > 1) {
								lines[num].add(new line(to, distance));
								lines[to].add(new line(num, distance));
							}
							break;
						}
					}
					// 우 체크
					int jFrom = j + 1;
					if (jFrom >= M)
						jFrom = M - 1;
					int jTo = M - 1;
					for (int c = jFrom; c <= jTo; c++) {
						if (map[i][c] == num)
							break;
						if (map[i][c] != 0) {
							int to = map[i][c];
							int distance = c - j - 1;
							if (distance > 1) {
								lines[num].add(new line(to, distance));
								lines[to].add(new line(num, distance));
							}
							break;
						}
					}
				}
			}
		}
		//// 프림 풀이
		// 정렬
		for (int i = 1; i <= islandNum; i++) {
			Collections.sort(lines[i]);
		}
		PriorityQueue<line> pq = new PriorityQueue<>();
		boolean[] canVisit = new boolean[islandNum + 1];
		// 총 거리
		int totalDistance = 0;
		// 시작 지점(임의로 지정)
		pq.offer(new line(1, 0));
		loop: while (!pq.isEmpty()) {
			line L = pq.remove();
			int cur = L.to;
			if (canVisit[cur])
				continue;
			canVisit[cur] = true;
			totalDistance += L.distance;
			for (line l : lines[cur]) {
				if (!canVisit[l.to])
					pq.offer(l);
			}
			for (int i = 1; i <= islandNum; i++) {
				if (!canVisit[i])
					continue loop;
			}
			break;
		}
		for (int i = 1; i <= islandNum; i++) {
			if (!canVisit[i]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(totalDistance);
	}

}
