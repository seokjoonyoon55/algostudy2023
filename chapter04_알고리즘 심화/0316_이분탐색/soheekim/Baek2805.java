package study0316;

import java.util.Scanner;

public class Baek2805 {
	static int[] tree;// 나무 길이 저장
	static int N;// 나무 갯수
	static int M;// 자를 목표

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N,M 입력받기
		String[] NM = sc.nextLine().split(" ");
		N = Integer.parseInt(NM[0]);// 나무 갯수
		M = Integer.parseInt(NM[1]);// 자를 목표

		tree = new int[N];// 나무 배열 할당
		int maxHeight = 0;// 나무 높이 중 최대값

		// 나무길이 String으로 입력받기
		String[] treeStr = sc.nextLine().split(" ");

		// 나무길이 int로 변환
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(treeStr[i]);
			// 나무 최대 갱신
			if (maxHeight < tree[i])
				maxHeight = tree[i];
		}

		// 이분탐색용 변수
		int start = 0;// 탐색 시작점
		int end = maxHeight;// 탐색 끝점
		int mid = -1;// 중간지점
		long temp = -1;// 자른 양 계산용 임시변수
		int cutHeight = -1;// 자를 수 있는 높이(최대 갱신 예정)

		// 이분탐색 수행
		while (start < end) {
			// 중간지점의 자른 양 계산
			mid = (start + end) / 2;
			temp = calWood(mid);

			// 자른 양이 목표량보다 크다면
			if (temp > M) {
				// 자른 높이가 최대라면 갱신
				if (cutHeight < mid)
					cutHeight = mid;
				// 시작점을 mid+1로 바꿈
				start = mid + 1;
			}
			// 자른 양이 목표량보다 작다면
			else if (temp < M)
				// 끝점을 mid로 바꿈
				end = mid;
			// 자른 양이 목표량과 일치한다면
			else if (temp == M) {
				// 자른 높이 갱신 및 반복 탈출
				cutHeight = mid;
				break;
			}
		}
		// 자른 높이 출력
		System.out.println(cutHeight);

		sc.close();

	}

	// 입력된 높이에서 자른 나무 양 계산 메서드
	public static long calWood(int height) {
		long sum = 0;// 자른 양
		int diff = -1;// 차이 저장용 임시변수

		// N개 나무에 대해
		for (int i = 0; i < N; i++) {
			// 차이가 0이상이라면 (잘리는 부분이 있다면) sum에 더함
			diff = tree[i] - height;
			if (diff > 0)
				sum += diff;
		}

		// 자른 나무의 합 반환
		return sum;
	}
}
