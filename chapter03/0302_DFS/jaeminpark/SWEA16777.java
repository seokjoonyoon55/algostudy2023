package im_prepare;

import java.util.Scanner;

public class SWEA16777 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 개수
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			// 신입 사원들 수
			int N = sc.nextInt();
			// 분반별 최소 인원
			int k_min = sc.nextInt();
			// 분반별 최대 인원
			int k_max = sc.nextInt();
			int[] scores = new int[N];
			// A반
			int adx = 0;
			int[] A = new int[500];
			// B반
			int bdx = 0;
			int[] B = new int[500];
			// C반
			int cdx = 0;
			int[] C = new int[500];

			// 점수배열에 신입사원들의 점수 넣기
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - i - 1; j++) {
					if (scores[j] > scores[j + 1]) {
						int temp = scores[j + 1];
						scores[j + 1] = scores[j];
						scores[j] = temp;
					}
				}
			}
			for (int i = N - 1; i >= 0; i--) {
				C[cdx++] = scores[i];
			}
			cdx = 0;
			while (true) {
				// bSize
				int bSize = 0;
				for (int i = 0; i < N; i++) {
					if (B[i] == 0) {
						bSize += i;
						break;
					}
					if (B[i] == -1) {
						bSize--;
					}
				}
				// C에서 B로 넘기기
				if (bSize < k_min) {
					int cToB = C[cdx];
					C[cdx] = -1;
					B[bdx++] = cToB;
					cdx++;
					while (C[cdx] == cToB) {
						B[bdx++] = C[cdx];
						C[cdx++] = -1;
					}
				}
				// aSize
				int aSize = 0;
				for (int i = 0; i < N; i++) {
					if (A[i] == 0) {
						aSize = i;
						break;
					}
				}
				// -1이 아닌 b의 첫 수
				bdx = 0;
				for (int i = 0; i < N; i++) {
					if (B[i] != -1) {
						bdx = i;
						break;
					}
				}
				// B에서 A로 넘기기
				if (aSize < k_min) {
					int bToA = B[bdx];
					B[bdx] = -1;
					bdx++;
					A[adx++] = bToA;
					while (B[bdx] == bToA) {
						A[adx++] = B[bdx];
						B[bdx++] = -1;
					}
				}
				// bSize
				bSize = 0;
				for (int i = 0; i < N; i++) {
					if (B[i] == 0) {
						bSize += i;
						break;
					}
					if (B[i] == -1) {
						bSize--;
					}
				}
				if (bSize >= k_min) {
					break;
				}
			}
			// 각 배열 사이즈 구하기
			int aSize = 0;
			int bSize = 0;
			int cSize = 0;
			for (int i = 0; i < 500; i++) {
				if (A[i] == 0) {
					break;
				}
				if (A[i] != -1) {
					aSize++;
				}
			}
			for (int i = 0; i < 500; i++) {
				if (B[i] == 0) {
					break;
				}
				if (B[i] != -1) {
					bSize++;
				}
			}
			for (int i = 0; i < 500; i++) {
				if (C[i] == 0) {
					break;
				}
				if (C[i] != -1) {
					cSize++;
				}
			}
			if (aSize >= k_min && aSize <= k_max && bSize >= k_min && bSize <= k_max && cSize >= k_min
					&& cSize <= k_max) {
				int maxSize = k_min;
				int minSize = k_max;
				if (aSize > maxSize) {
					maxSize = aSize;
				}
				if (bSize > maxSize) {
					maxSize = bSize;
				}
				if (cSize > maxSize) {
					maxSize = cSize;
				}
				if (aSize < minSize) {
					minSize = aSize;
				}
				if (bSize < minSize) {
					minSize = bSize;
				}
				if (cSize < minSize) {
					minSize = cSize;
				}
				System.out.println("#" + (t + 1) + " " + (maxSize - minSize));
			} else {
				System.out.println("#" + (t + 1) + " " + -1);
			}
		}

	}

}
