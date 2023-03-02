package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon4963_bfs {
	public static class Cordinate {
		int r;
		int c;

		public Cordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			// 섬의 개수
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						visited[i][j] = true;
					}
				}
			}

			Queue<Cordinate> q = new ArrayDeque<>();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						cnt++;
						q.offer(new Cordinate(i, j));
						while (!q.isEmpty()) {
							Cordinate island = q.remove();
							int I = island.r;
							int J = island.c;
							for (int k = 0; k < 8; k++) {
								int nextI = I + dx[k];
								int nextJ = J + dy[k];
								if (nextI >= 0 && nextI < h && nextJ >= 0 && nextJ < w) {
									if (!visited[nextI][nextJ]) {
										visited[nextI][nextJ] = true;
										q.offer(new Cordinate(nextI, nextJ));
									}
								}
							}
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
