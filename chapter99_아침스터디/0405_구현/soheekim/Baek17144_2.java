package study0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek17144_2 {
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int R, C, T, down;
	static int[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String[] RCT = bfr.readLine().split(" ");
		R = Integer.parseInt(RCT[0]);// 행
		C = Integer.parseInt(RCT[1]);// 열
		T = Integer.parseInt(RCT[2]);// 시간

		field = new int[R][C];// 먼지 상태
		int sum = 0;

		// 먼지 입력받기
		String[] tempS;
		for (int r = 0; r < R; r++) {
			tempS = bfr.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				field[r][c] = Integer.parseInt(tempS[c]);
				if (field[r][c] == -1)
					down = r;
			}
		}

		// T까지 시간에 대해
		for (int time = 0; time < T; time++) {
			// 먼지 확산 메서드
			field = spread();

			// 위쪽 순환 메서드
			moveUp();

			// 아래쪽 순환 메서드
			moveDown();

		}

		// 모든 칸 먼지 더함
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (field[r][c] > 0)
					sum += field[r][c];
			}
		}

		// 출력
		System.out.println(sum);

	}

	// 먼지 확산 메서드
	public static int[][] spread() {
		// 확산 후 저장할 배열
		int[][] after = new int[R][C];

		// 모든 칸에 대해
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 확산할 만큼 먼지가 있는 칸이면
				if (field[r][c] >= 5) {
					int dustOut = field[r][c] / 5;
					for (int dir = 0; dir < 4; dir++) {
						// 경계조건
						if (r + dr[dir] < 0 || r + dr[dir] >= R || c + dc[dir] < 0 || c + dc[dir] >= C)
							continue;

						// 공청기 확산안됨
						if (field[r + dr[dir]][c + dc[dir]] == -1)
							continue;

						after[r + dr[dir]][c + dc[dir]] += dustOut;
						field[r][c] -= dustOut;

					}
					after[r][c] += field[r][c];
				}
				// 확산 안될 만큼만 먼지가 있는 칸이면
				else if (field[r][c] > 0)
					after[r][c] += field[r][c];
				// 공기청정기 칸이면
				else if (field[r][c] == -1)
					after[r][c] = -1;
			}
		}
		return after;
	}

	//위쪽 순환 메서드
	public static void moveUp() {
		int up = down - 1;
		// 아래로
		for (int r = up - 1; r >= 0; r--) {
			if (field[r][0] == field[r + 1][0])
				continue;

			if (field[r + 1][0] != -1) {
				field[r + 1][0] = field[r][0];
			}
		}

		// 왼쪽으로
		for (int c = 1; c < C; c++) {
			if (field[0][c] == field[0][c - 1])
				continue;

			field[0][c - 1] = field[0][c];
		}

		// 위로
		for (int r = 1; r <= up; r++) {
			if (field[r][C - 1] == field[r - 1][C - 1])
				continue;

			field[r - 1][C - 1] = field[r][C - 1];
		}

		// 오른쪽으로
		for (int c = C - 2; c >= 0; c--) {
			if (field[up][c] == field[up][c + 1])
				continue;

			if (field[up][c] != -1)
				field[up][c + 1] = field[up][c];
			else
				field[up][c + 1] = 0;
		}

	}

	//아래쪽 순환 메서드
	public static void moveDown() {
		// 위로
		for (int r = down + 1; r < R; r++) {
			if (field[r][0] == field[r - 1][0])
				continue;

			if (field[r - 1][0] != -1) {
				field[r - 1][0] = field[r][0];
			}
		}

		// 왼쪽으로
		for (int c = 1; c < C; c++) {
			if (field[R - 1][c] == field[R - 1][c - 1])
				continue;

			field[R - 1][c - 1] = field[R - 1][c];
		}

		// 아래로
		for (int r = R - 2; r >= down; r--) {
			if (field[r][C - 1] == field[r + 1][C - 1])
				continue;

			field[r + 1][C - 1] = field[r][C - 1];

		}

		// 오른쪽으로
		for (int c = C - 2; c >= 0; c--) {
			if (field[down][c] == field[down][c + 1])
				continue;

			if (field[down][c] != -1)
				field[down][c + 1] = field[down][c];
			else
				field[down][c + 1] = 0;

		}
	}

}
