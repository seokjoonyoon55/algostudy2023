package baekjoon_02_Silver;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon7562 {

	public static class cordinate {
		int r;
		int c;

		public cordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			Queue<cordinate> q = new ArrayDeque<>();
			int N = sc.nextInt();
			int[][] chess = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			q.offer(new cordinate(sc.nextInt(), sc.nextInt()));
			visited[q.peek().r][q.peek().c] = true;
			cordinate dest = new cordinate(sc.nextInt(), sc.nextInt());
			int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
			int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
			int answer = 0;
			loop: while (!q.isEmpty()) {
				cordinate x = q.remove();
				int R = x.r;
				int C = x.c;
				for (int i = 0; i < 8; i++) {
					int nextR = R + dx[i];
					int nextC = C + dy[i];
					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
						if (!visited[nextR][nextC]) {
							visited[nextR][nextC] = true;
							q.offer(new cordinate(nextR, nextC));
							chess[nextR][nextC] = chess[R][C] + 1;
							if (nextR == dest.r && nextC == dest.c) {
								answer = chess[R][C] + 1;
								break loop;
							}
						}
					}
				}
			}
			System.out.println(answer);
		}
	}

}
