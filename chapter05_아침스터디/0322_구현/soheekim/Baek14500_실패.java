package study0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//실패
public class Baek14500 {

	// 우 하 상 좌
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };

	static int N;
	static int M;
	static int[][] board;
	static boolean[][] visited;
	static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = bfr.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		// 숫자 입력받기
		board = new int[N][M];
		visited = new boolean[N][M];
		String[][] tempS = new String[N][M];
		for (int i = 0; i < N; i++) {
			tempS[i] = bfr.readLine().split(" ");
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tempS[i][j]);
			}
		}

		// T자형 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				calT(i, j);
			}
		}

		// ㅁ형 계산
		calSquare();

		// 나머지 모양 dfs로 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
			}
		}

		System.out.println(maxSum);

	}

	public static void dfs(int r, int c, int sum, int length) {

		if (length == 3) {
			if (maxSum < sum)
				maxSum = sum;
			return;
		}

		if (length == 0) {
			sum = board[r][c];
		}

		for (int i = 0; i < 3; i++) {
			// 경계조건
			if (r + dr[i] >= N || r + dr[i] < 0 || c + dc[i] >= M || c + dc[i] < 0)
				continue;
			if (!visited[r + dr[i]][c + dc[i]]) {
				visited[r + dr[i]][c + dc[i]] = true;
				sum += board[r + dr[i]][c + dc[i]];

				dfs(r + dr[i], c + dc[i], sum, length + 1);

				sum -= board[r + dr[i]][c + dc[i]];
				visited[r + dr[i]][c + dc[i]] = false;
			}
		}

	}

	// 정사각형
	public static void calSquare() {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				sum = board[i][j] + board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1];
				if (maxSum < sum)
					maxSum = sum;
			}
		}
	}

	// T자형
	public static void calT(int r, int c) {
		int sum = 0;
		int temp = -1;
		for (int i = 0; i < 4; i++) {
			sum = board[r][c];
			for (int j = 1; j <= 3; j++) {
				temp = (i + j) % 4;
				// 경계조건
				if (r + dr[temp] >= N || r + dr[temp] < 0 || c + dc[temp] >= M || c + dc[temp] < 0)
					return;

				sum += board[r + dr[temp]][c + dc[temp]];

			}
			if (maxSum < sum)
				maxSum = sum;
		}
	}

}
