package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon14889__ {
	static int N;
	static int[] teamA;
	static boolean[] isUsed;
	static int[][] stats;
	static int Astats;
	static int Bstats;
	static int dif;
	static int minDif = 100;
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		teamA = new int[N / 2];
		int[] teamB = new int[N / 2];
		isUsed = new boolean[N];
		stats = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Team(0);
		System.out.println(set);
		for (String x : set) {
			String[] teamA = x.toString().split(" ");
			System.out.println(Arrays.toString(teamA));
			int bIndex = 0;
			int num = 0;
			int c = 0;
			while (num < N) {
				c = 0;
				for (int j = 0; j < teamA.length; j++) {
					if (teamA[j].equals(Integer.toString(num))) {
						c++;
					}
				}
				if (c == 0) {
					teamB[bIndex] = num;
					bIndex++;
				}
				num++;
			}
//			System.out.println("teamA: " + Arrays.toString(teamA));
//			System.out.println("teamB: " + Arrays.toString(teamB));
//			System.out.println("==================================");
			Astats = 0;
			Bstats = 0;
			int indexI = 0;
			int indexJ = 1;
			while (indexI != teamA.length) {
				if (indexI != indexJ) {
					int a = Integer.parseInt(teamA[indexI]);
					int b = Integer.parseInt(teamA[indexJ]);
//					System.out.printf("ateam : %d %d", a, b);
//					System.out.println();
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
//					System.out.printf("bteam : %d %d", a, b);
//					System.out.println();
					Bstats += stats[a][b];
				}
				indexJ++;
				if (indexJ == teamB.length) {
					indexJ = 0;
					indexI++;
				}
			}
//			System.out.println(Astats);
//			System.out.println(Bstats);

			dif = Math.abs(Astats - Bstats);
			if (dif < minDif) {
				minDif = dif;
			}

		}
		System.out.println(minDif);
	}

	static void Team(int depth) {
		if (depth == N / 2) {
			boolean flag = true;
			// 중복 되는 값이 있을 경우 teamA에 넣기 제외
			for (int i = 0; i < N / 2 - 1; i++) {
				if (teamA[i] == teamA[i + 1]) {
					flag = false;
					break;
				}
			}
			sb.setLength(0);
			if (flag) {
				for (int i = 0; i < N / 2; i++) {
					sb.append(teamA[i]).append(" ");
				}
				set.add(sb.toString());
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				if (depth != 0) {
					if (teamA[depth - 1] < i) {
						teamA[depth] = i;
					} else {
					}
				} else {
					teamA[depth] = i;
				}
				Team(depth + 1);

				isUsed[i] = false;
			}
		}
	}
}
