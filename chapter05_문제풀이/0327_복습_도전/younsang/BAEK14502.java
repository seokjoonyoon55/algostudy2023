package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK14502 {
	static int N,M, max;
	static int[][] graph, temp;
	static Queue<int[]> q;
	static boolean[][] visit;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		makeWall(0);
		System.out.println(max);
	}
	
	public static void makeWall(int cnt) {
		// base case
		if (cnt == 3) {
			int count = 0;
			temp = graph.clone();
			visit = new boolean[N][M];
			System.out.println(Arrays.deepToString(temp));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 2 && !visit[i][j]) bfs(i,j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0) count++;
				}
			}
			max = Math.max(max, count);
			return;
		}
		
		
		// recur case
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] != 0) continue;
				graph[i][j] = 1;
				makeWall(cnt + 1);
				graph[i][j] = 0;
			}
		}
	}
	
	public static void bfs(int x, int y) {
		
		q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int[] ele = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = ele[0] + dx[i];
				int ny = ele[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (visit[nx][ny]) continue;
				if (temp[nx][ny] == 0) {
					visit[nx][ny] = true;
					temp[nx][ny] = 2;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}
