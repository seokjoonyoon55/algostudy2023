package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BAEK2468 {
	static int N;
	static int[][] arr;
	static LinkedList<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 제일 높은 곳
				max = (arr[i][j] > max) ? arr[i][j] : max;
			}
		}
		
		// 안전 영역
		int safeArea = 0;
		
		// 0부터 제일 높은 곳 까지 반복
		for (int i = 0; i < max; i++) {
			// 안전영역이 최대인 곳 판별
			if (bfs(i) >= safeArea) safeArea = bfs(i);
		}
		System.out.println(safeArea);
	}
	public static int bfs(int height) {
		int[][] visit = new int[N][N];
		
		q = new LinkedList<>();
		
		int cnt = 0;
		int area = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 높이보다 높고, 방문안했을 때
				if (arr[i][j] > height && visit[i][j] == 0) {
					// 큐에 넣고
					q.add(new int[] {i,j});
					// 방문 처리
					visit[i][j] = 1;
					cnt++;
					while (!q.isEmpty()) {
						int[] ele = q.remove();
						for (int k = 0; k < 4; k++) {
							int x = ele[0] + dx[k];
							int y = ele[1] + dy[k];
							
							// 범위 벗어났을 때
							if (x < 0 || x >= N || y < 0 || y >= N) continue;
							if (arr[x][y] > height && visit[x][y] == 0) {
								visit[x][y] = 1;
								q.add(new int[] {x, y});
							}
						}
					}
				}
				// cnt가 0보다 크면 안전영역이므로
				// boolean 변수 써도 될듯.
				if (cnt > 0) {
					area++;
					cnt = 0;
				}
			}
		}
		return area;
	}
}
