package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.NullPointerException;

public class BAEK4963 {
	static String[] wh;
	static int w, h;
	static int[][] arr;
	static int[][] visit;
	// 8방향 탐색
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int cnt;
	public static void main(String[] args) throws NullPointerException, NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = " ";
		while (!(str = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			visit = new int[h][w];
			cnt = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// 섬이 존재하고 방문하지 않았을 경우 dfs
					// count
					if (arr[i][j] == 1 && visit[i][j] == 0) {
						dfs(new int[] {i, j});
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int[] loc) {
		// 방문 처리
		visit[loc[0]][loc[1]] = 1;
		// 8방향 탐색
		for (int i = 0; i < 8; i++) {
			int nx = loc[0] + dx[i];
			int ny = loc[1] + dy[i];
			
			// 범위 벗어나면 continue;
			if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
			// 방문하지 않았고 섬이 존재하면
			if (visit[nx][ny] == 0 && arr[nx][ny] == 1) {
				// 재귀
				dfs(new int[] {nx, ny});
			}
		}
	}
}