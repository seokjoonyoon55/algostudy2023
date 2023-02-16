package study0216;

import java.util.Scanner;

public class Baek14889 {
	public static int currentIdx = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] curentArr=new int[N];

		int[][] stats = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				stats[i][j] = sc.nextInt();
			}
		}
		int max = N;
		int[] arr = { 1, 2, 3, 4 };
		int[] curArr = new int[3];
		boolean[] visited = new boolean[max];
		int curIdx = 0;

		combination(visited, max, arr, curArr, curIdx);

//		for (int i = 0; i < max; i++) {
//			for (int j = 0; j < max; j++) {
//				if (j != i) {
//					for (int k = 0; k < max; k++) {
//						if (k != i && k != j && i < j && j < k)
//							System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
//					}
//				}
//			}
//		}

	}

	public static void combination(boolean[] visited, int maxIdx, int[] arr, int[] curArr, int curIdx) {

		if (curIdx == curArr.length) {
			if(isAscend(curArr)) {
				for (int i = 0; i < curArr.length; i++) {
					System.out.print(curArr[i] + " ");
				}
				System.out.println();
			}

		}

		else {
			for (int i = 0; i < maxIdx; i++) {
				if (visited[i] == false) {
					curArr[curIdx] = arr[i];
					visited[i] = true;
					combination(visited, maxIdx, arr, curArr, curIdx + 1);
					visited[i] = false;
				}
			}
			curIdx--;

		}
	}

	public static boolean isAscend(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>=arr[i+1]) return false;
		}
		return true;
	}
}
