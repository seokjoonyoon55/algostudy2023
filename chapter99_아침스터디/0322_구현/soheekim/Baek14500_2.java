package study0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//39460KB 840ms
public class Baek14500_2 {

	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static int N;// 행 r 수
	static int M;// 열 c 수
	static int[][] board;// 숫자 저장 배열
	static boolean[][] visited;// 방문 여부 저장 배열
	static int maxSum = Integer.MIN_VALUE;// 합 최대

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = bfr.readLine().split(" ");
		N = Integer.parseInt(NM[0]);// 행 수
		M = Integer.parseInt(NM[1]);// 열 수

		// 숫자 배열, 방문여부 배열 할당
		board = new int[N][M];
		visited = new boolean[N][M];

		// 숫자 입력받기 (String으로 받음)
		String[][] tempS = new String[N][M];
		for (int i = 0; i < N; i++) {
			tempS[i] = bfr.readLine().split(" ");
		}

		// String->int로 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tempS[i][j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				backR(i, j, 0, 0);// 하향 우향만 하는 백트래킹
				backL(i, j, 0, 0);// 하향 좌향만 하는 백트래킹
				calT(i, j);// T자형 계산
				calSquare(i, j);// 네모 계산
			}
		}

		System.out.println(maxSum);

	}

	// 하 우
	public static void backR(int r, int c, int sum, int length) {

		// 4개 다 세면 최대합 갱신
		if (length == 3) {
			if (maxSum < sum)
				maxSum = sum;
			return;
		}

		// 시작점이면 sum에 시작값 저장
		if (length == 0) {
			sum = board[r][c];
		}

		// 델타탐색 우0, 하1 실행
		for (int i = 0; i < 2; i++) {
			// 경계조건
			if (r + dr[i] >= N || r + dr[i] < 0 || c + dc[i] >= M || c + dc[i] < 0)
				continue;
			// 다음칸이 방문 안됐으면
			if (!visited[r + dr[i]][c + dc[i]]) {
				// 방문표시 후 합에 더함
				visited[r + dr[i]][c + dc[i]] = true;
				sum += board[r + dr[i]][c + dc[i]];

				// 다음칸에 대해 백트래킹
				backR(r + dr[i], c + dc[i], sum, length + 1);

				// 되돌림
				sum -= board[r + dr[i]][c + dc[i]];
				visited[r + dr[i]][c + dc[i]] = false;
			}
		}
	}

	// 하 좌
	public static void backL(int r, int c, int sum, int length) {
		// 4개 다 세면 최대합 갱신
		if (length == 3) {
			if (maxSum < sum)
				maxSum = sum;
			return;
		}

		// 시작점이면 sum에 시작값 저장
		if (length == 0) {
			sum = board[r][c];
		}

		// 델타탐색 하1, 좌2 실행
		for (int i = 1; i < 3; i++) {
			// 경계조건
			if (r + dr[i] >= N || r + dr[i] < 0 || c + dc[i] >= M || c + dc[i] < 0)
				continue;
			// 다음칸이 방문 안됐으면
			if (!visited[r + dr[i]][c + dc[i]]) {
				// 방문표시 후 합에 더함
				visited[r + dr[i]][c + dc[i]] = true;
				sum += board[r + dr[i]][c + dc[i]];

				// 다음칸에 대해 백트래킹
				backL(r + dr[i], c + dc[i], sum, length + 1);

				// 되돌림
				sum -= board[r + dr[i]][c + dc[i]];
				visited[r + dr[i]][c + dc[i]] = false;
			}
		}
	}

	// 정사각형
	public static void calSquare(int r, int c) {
		int sum = 0;

		// 경계조건
		if (r + 1 >= N || r + 1 < 0 || c + 1 >= M || c + 1 < 0)
			return;

		// 4칸 합
		sum = board[r][c] + board[r + 1][c] + board[r][c + 1] + board[r + 1][c + 1];

		// 최대값 갱신
		if (maxSum < sum)
			maxSum = sum;
	}

	// T자형
	public static void calT(int r, int c) {
		int sum = 0;// 합
		int temp = -1;// 계산용 임시변수

		// 4방향에 대해 i번째 방향이 없는 경우 계산
		for (int i = 0; i < 4; i++) {
			// 가운데값으로 초기화
			sum = board[r][c];

			// i번쨰 방향을 제외한 나머지 방향을 더해줌
			for (int j = 1; j <= 3; j++) {
				temp = (i + j) % 4;// 방향 재계산

				// 경계조건
				if (r + dr[temp] >= N || r + dr[temp] < 0 || c + dc[temp] >= M || c + dc[temp] < 0)
					break;

				// i번째 방향이 아닌 방향을 합에 저장
				sum += board[r + dr[temp]][c + dc[temp]];

			}
			// 최대합 갱신
			if (maxSum < sum)
				maxSum = sum;
		}
	}
}
