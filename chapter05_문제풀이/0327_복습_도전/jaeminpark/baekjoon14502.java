package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon14502 {

	static int N;
	static int M;
	static int[][] lab;
	static boolean[][] visited;
	static Coordinate[] wall = new Coordinate[3];
	static List<Coordinate> zero = new ArrayList<>();
	static boolean[] isUsed;
	static int area;
	static int maxArea;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bt(int depth) {
		if (depth == 3) {
			int[][] tempLab = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tempLab[i][j] = lab[i][j];
				}
			}
			visited = new boolean[N][M];
			for (int i = 0; i < 3; i++) {
				tempLab[wall[i].r][wall[i].c] = 1;
			}
			Queue<Coordinate> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tempLab[i][j] == 2) {
						q.offer(new Coordinate(i, j));
						while (!q.isEmpty()) {
							Coordinate K = q.remove();
							int R = K.r;
							int C = K.c;
							visited[R][C] = true;
							for (int k = 0; k < 4; k++) {
								int nR = R + dx[k];
								int nC = C + dy[k];
								if (nR < 0 || nR >= N || nC < 0 || nC >= M) {
									continue;
								}
								if (!visited[nR][nC] && tempLab[nR][nC] == 0) {
									visited[nR][nC] = true;
									tempLab[nR][nC] = 2;
									q.offer(new Coordinate(nR, nC));
								}
							}
						}
					}
				}
			}
			area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tempLab[i][j] == 0) {
						area++;
					}
				}
			}
			if (maxArea < area) {
				maxArea = area;
			}
			return;
		}
		for (int i = 0; i < zero.size(); i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				wall[depth] = zero.get(i);
				bt(depth + 1);
				isUsed[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 0) {
					zero.add(new Coordinate(i, j));
				}
			}
		}
		isUsed = new boolean[zero.size()];

		bt(0);
		System.out.println(maxArea);
	}

	public static class Coordinate {
		int r;
		int c;

		Coordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
