package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon14889 {
	// 총 인원수
	static int N;
	// 팀 A 인원 배열
	static int[] teamA;
	// 팀 B 인원 배열
	static int[] teamB;
	// 총 인원 중 teamA나 teamB에 포함된 사람의 인덱스
	static boolean[] isUsed;
	// 팀원들의 능력치 저장할 2차원 배열
	static int[][] stats;
	// A팀의 능력치
	static int Astats;
	// B팀의 능력치
	static int Bstats;
	// A팀과 B팀의 능력치 차이
	static int dif;
	// A팀과 B팀의 능력치 차이의 최솟값
	static int minDif = 100;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 총 인원수 받아오기
		N = Integer.parseInt(br.readLine());
		// teamA 배열 크기 정하기
		teamA = new int[N / 2];
		// teamB 배열 크기 정하기
		teamB = new int[N / 2];
		// 총 인원수 팀에 포함됐는지 여부 정할 배열 크기 정하기
		isUsed = new boolean[N];
		// 능력치 저장할 2차원 배열 선언
		stats = new int[N][N];
		// 2차원 배열 제작
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 시작
		Team(0);
		System.out.println(minDif);
	}

	static void Team(int depth) {
		// if 문 아래에 있는 for문 부터 보기
		if (depth == N / 2) {

			int bIndex = 0;
			int num = 0;
			int c = 0;
			while (num < N) {
				c = 0;
				for (int j = 0; j < teamA.length; j++) {
					if (teamA[j] == num) {
						c++;
					}
				}
				if (c == 0) {
					teamB[bIndex] = num;
					bIndex++;
				}
				num++;
			}

			Astats = 0;
			Bstats = 0;
			int indexI = 0;
			int indexJ = 1;
			while (indexI != teamA.length) {
				if (indexI != indexJ) {
					int a = teamA[indexI];
					int b = teamA[indexJ];
					Astats += stats[a][b];
				}
				indexJ++;
				if (indexJ == teamA.length) {
					indexJ = 0;
					indexI++;
				}
			}
			indexI = 0;
			indexJ = 1;
			while (indexI != teamB.length) {
				if (indexI != indexJ) {
					int a = teamB[indexI];
					int b = teamB[indexJ];
					Bstats += stats[a][b];
				}
				indexJ++;
				if (indexJ == teamB.length) {
					indexJ = 0;
					indexI++;
				}
			}

			dif = Math.abs(Astats - Bstats);
			if (dif < minDif) {
				minDif = dif;
			}

			return;
		}

		// 여기가 핵심
		for (int i = 0; i < N; i++) {
			// i인덱스의 사람이 팀에 안넣어졌다면
			if (!isUsed[i]) {
				// 팀에 넣을 것이란걸 표시하고
				isUsed[i] = true;
				// 여기가 핵심 중에 핵심임
				if (depth != 0) {
					// teamA만 짜고 위에 큰 if문에서 teamB 따질건데
					// teamA를 그냥 백트레킹으로 하면 경우의 수가 너무 많아짐
					// => teamA의 앞 사람보다 뒷 사람이 더 숫자가 큰 경우만 오게 하면 중복이 없어짐
					// 반대도 가능
					if (teamA[depth - 1] < i) {
						// 조건을 만족하는 경우에만 teamA에 구성시키고
						teamA[depth] = i;
						// 다음 재귀를 돌림
						Team(depth + 1);
					}
					// 아래 else문 말고 생략된 엘스문에 대한 설명
					// => 만약 teamA[depth -1] 보다 다음에 올 사람의 숫자가 크면
					// 다음 재귀로 안보냄 -> 여기서 걸러야 시간 복잡도를 줄일 수 있음
				} else {
					// depth가 0일 경우엔 한명밖에 없으니까 그냥 넣고 다음 재귀 돌리기
					teamA[depth] = i;
					Team(depth + 1);
				}
				// 썼던건 다음 재귀때 사용할 수 있게 안 썼다고 표시하고 넘기기
				isUsed[i] = false;
			}
		}
	}
}
