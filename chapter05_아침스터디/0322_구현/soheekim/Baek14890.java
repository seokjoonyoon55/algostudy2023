package study0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek14890 {
	static int[][] land;
	static int N;
	static int L;
	static int cnt = 0;
	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] NL = bfr.readLine().split(" ");
		N = Integer.parseInt(NL[0]);
		L = Integer.parseInt(NL[1]);

		land = new int[N][N];
		String[][] tempS = new String[N][N];
		for (int i = 0; i < N; i++) {
			tempS[i] = bfr.readLine().split(" ");
		}

		// 땅 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				land[i][j] = Integer.parseInt(tempS[i][j]);
			}
		}

		for (int r = 0; r < N; r++) {
			calSmooth(r, 0, 0);// headDown 0 우향
		}

		for (int c = 0; c < N; c++) {
			calSmooth(0, c, 1);// headDown 1 하향
		}
		System.out.println(cnt);

	}

	// headDown 0이면 우향 1이면 하향
	public static void calSmooth(int r, int c, int headDown) {
		//System.out.println("r c " + r + " " + c);
		boolean smooth = true;
		boolean[] ramp = new boolean[N];

		int curR = r;
		int curC = c;

		int diff = 0;
		boolean success = true;

		// 위>아래 / 왼>오로 가면서 1낮아지는거 찾아서 경사로 놓기
		for (int line = 0; line < N - 1; line++) {
			success = true;

			diff = land[curR][curC] - land[curR + dr[headDown]][curC + dc[headDown]];
			// -_이면
			if (diff == 1) {
				success = installRamp(curR + dr[headDown], curC + dc[headDown], headDown, ramp);
				if (!success)
					return;
			}
			// _-이면
			else if (diff == -1) {
				success = installRamp(curR, curC, headDown + 2, ramp);
				if (!success)
					return;
			}
			//높이차 크면
			else if (diff < -1 || diff > 1)
				return;

			curR += dr[headDown];
			curC += dc[headDown];
		}
		//System.out.println("r c " + r + " " + c + " success");
		cnt++;

	}

	public static boolean installRamp(int r, int c, int direction, boolean[] ramp) {
		int curR = r;
		int curC = c;
		int height = land[r][c];

		int curB = direction % 2 == 0 ? c : r;
		int idx = curB;
		int add = direction < 2 ? 1 : -1;

		for (int i = 0; i < L; i++) {
			// 경계조건
			if (curR < 0 || curR >= N || curC < 0 || curC >= N)
				return false;

			// 이미 경사로 있으면 종료
			if (ramp[curB])
				return false;

			// 높이 유지 안되면 종료
			if (land[curR][curC] != height)
				return false;
			// 높이 유지되면
			else {
				curR += dr[direction];
				curC += dc[direction];
				curB = direction % 2 == 0 ? curC : curR;
			}
		}

		for (int i = 0; i < L; i++) {
			ramp[idx] = true;
			idx += add;
		}

		return true;
	}

}
