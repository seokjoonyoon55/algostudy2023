package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon17144 {

	static int R;
	static int C;
	static int[][] map;
	static Coordinate[] purifier = new Coordinate[2];
	static List<Coordinate> dust = new ArrayList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Coordinate {
		int r, c, quantity;

		Coordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Coordinate(int r, int c, int quantity) {
			this.r = r;
			this.c = c;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "Coordinate [r=" + r + ", c=" + c + ", quantity=" + quantity + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 행
		R = Integer.parseInt(st.nextToken());
		// 열
		C = Integer.parseInt(st.nextToken());
		// 지난 시간
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int pdx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if (val == -1) {
					purifier[pdx++] = new Coordinate(i, j);
				} else if (val != 0) {
					dust.add(new Coordinate(i, j, val));
				}
			}
		}
		while (T > 0) {
			// 확산
			spread();
			// 청정기 가동
			runPurifier();
			// 시간 줄이기
			T--;
		}
		int total = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1) {
					total += map[i][j];
				}
			}
		}
		System.out.println(total);
	}

	// 확산 메소드
	private static void spread() {
		// 새판 짜기
		int[][] newMap = new int[R][C];
		int size = dust.size();
		for (int i = 0; i < size; i++) {
			Coordinate d = dust.get(i);
			int quant = d.quantity;
			for (int j = 0; j < 4; j++) {
				int nI = d.r + dx[j];
				int nJ = d.c + dy[j];
				boolean purifierExist = false;
				// 확산할 위치가 공기청정기가 있는 곳인지 판별할 for문
				for (Coordinate k : purifier) {
					if (k.r == nI && k.c == nJ) {
						purifierExist = true;
						break;
					}
				}
				if (nI < 0 || nJ < 0 || nI >= R || nJ >= C || purifierExist)
					continue;
				newMap[nI][nJ] += quant / 5;
				dust.get(i).quantity -= quant / 5;
				dust.add(new Coordinate(nI, nJ, quant / 5));
			}
		}
		// 새판에다가 원래 먼지 있던 자리에 줄어든 먼지양 더해주기
		for (int i = 0; i < size; i++) {
			Coordinate d = dust.get(i);
			newMap[d.r][d.c] += d.quantity;
		}
		// 맵에 deepCopy? 해주기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = newMap[i][j];
			}
		}
		// 공기 청정기 배치
		for (Coordinate k : purifier) {
			map[k.r][k.c] = -1;
		}
	}

	private static void runPurifier() {
		// 공기 청정기 위에 순환(공기 청정기로 내려오기)
		for (int i = purifier[0].r - 1; i >= 1; i--) {
			map[i][0] = map[i - 1][0];
		}
		// 공기 청정기 아래 순환(공기 청정기로 올라오기)
		for (int i = purifier[1].r + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		// 방 윗 부분, 아랫부분 순환(<==)
		for (int j = 0; j < C - 1; j++) {
			map[0][j] = map[0][j + 1];
			map[R - 1][j] = map[R - 1][j + 1];
		}
		// 오른쪽 가생이 위로 올라오는 순환
		for (int i = 0; i < purifier[0].r; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		// 오른쪽 가생이 아래로 내려오는 순환
		for (int i = R - 1; i > purifier[1].r; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		// 방 가운데 순환(==>)
		for (int j = C - 1; j >= 1; j--) {
			map[purifier[0].r][j] = map[purifier[0].r][j - 1];
			map[purifier[1].r][j] = map[purifier[1].r][j - 1];
		}
		// 공기청정기 바로 오른쪽 0으로 초기화
		map[purifier[0].r][1] = 0;
		map[purifier[1].r][1] = 0;
		// 새로 만든 리스트에 먼지 정보 담기
		List<Coordinate> newDust = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1 && map[i][j] != 0) {
					newDust.add(new Coordinate(i, j, map[i][j]));
				}
			}
		}
		// static 리스트 새로만든 리스트로 바꾸기
		dust = newDust;
	}

}
