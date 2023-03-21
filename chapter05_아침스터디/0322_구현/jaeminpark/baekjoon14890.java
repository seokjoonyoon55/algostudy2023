package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 지도 크기
		int N = Integer.parseInt(st.nextToken());
		// 경사로 길이
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 지날 수 있는 길의 개수
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// 경사로를 놓아서라도 지나갈 수 있는 길인지
			boolean canCross = true;
			// 경사로가 놓여져있는지 체크할 배열
			boolean[] slopeExist = new boolean[N];
			// 행 길 먼저 판단
			loop: for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					continue;
				} else if (map[i][j] + 1 == map[i][j + 1]) { // 경사로를 놓을 수 있는 단차라면
					// 경사로 놓을 공간이 충분한지 체크
					if (j - L + 1 < 0) {
						canCross = false;
						break;
					}
					// 땅이 평탄한지 체크
					int height = map[i][j];
					for (int k = j; k >= j - L + 1; k--) {
						if (map[i][k] != height || slopeExist[k]) {
							canCross = false;
							break loop;
						}
					}
					// 슬로프를 놔서 건널 수 있는 길이라면 슬로프 놓기
					if (canCross) {
						for (int k = j; k >= j - L + 1; k--) {
							slopeExist[k] = true;
						}
					}
				} else if (map[i][j] - 1 == map[i][j + 1]) { // 경사로를 놓을 수 있는 단차라면
					// 경사로 놓을 공간이 충분한지 체크
					if (j + L >= N) {
						canCross = false;
						break;
					}
					// 땅이 평탄한지 체크
					int height = map[i][j + 1];
					for (int k = j + 1; k <= j + L; k++) {
						if (map[i][k] != height || slopeExist[k]) {
							canCross = false;
							break loop;
						}
					}
					// 슬로프를 놔서 건널 수 있는 길이라면 슬로프 놓기
					if (canCross) {
						for (int k = j + 1; k <= j + L; k++) {
							slopeExist[k] = true;
						}
					}
				} else { // 경사로를 놓을 수 없는 단차라면 다음 행으로 이동
					canCross = false;
					break;
				}
			}
			if (canCross) {
				cnt++;
			}
		}

		for (int j = 0; j < N; j++) {
			boolean canCross = true;
			boolean[] slopeExist = new boolean[N];
			// 열 길 판단
			loop: for (int i = 0; i < N - 1; i++) {
				if (map[i][j] == map[i + 1][j]) { // 땅의 높이가 같을 경우 패스
					continue;
				} else if (map[i][j] + 1 == map[i + 1][j]) { // 경사로를 놓을 수 있는 단차라면
					// 경사로 놓을 공간이 충분한지 체크
					if (i - L + 1 < 0) {
						canCross = false;
						break;
					}
					// 땅이 평탄한지 체크
					int height = map[i][j];
					for (int k = i; k >= i - L + 1; k--) {
						if (map[k][j] != height || slopeExist[k]) {
							canCross = false;
							break loop;
						}
					}
					// 슬로프를 놔서 건널 수 있는 길이라면 슬로프 놓기
					if (canCross) {
						for (int k = i; k >= i - L + 1; k--) {
							slopeExist[k] = true;
						}
					}
				} else if (map[i][j] - 1 == map[i + 1][j]) { // 경사로를 놓을 수 있는 단차라면
					// 경사로 놓을 공간이 충분한지 체크
					if (i + L >= N) {
						canCross = false;
						break;
					}
					// 땅이 평탄한지 체크
					int height = map[i + 1][j];
					for (int k = i + 1; k <= i + L; k++) {
						if (map[k][j] != height || slopeExist[k]) {
							canCross = false;
							break loop;
						}
					}
					// 슬로프를 놔서 건널 수 있는 길이라면 슬로프 놓기
					if (canCross) {
						for (int k = i + 1; k <= i + L; k++) {
							slopeExist[k] = true;
						}
					}
				} else { // 경사로를 놓을 수 없는 단차라면 다음 열로 이동
					canCross = false;
					break;
				}
			}
			if (canCross) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
