package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		// 나무의 길이 리스트
		List<Long> wood = new ArrayList<>();
		// 나무의 길이 리스트 중 max값보다 큰 나무의 개수
		// max값 점점 줄어들 거임(1 줄어들면 max보다 큰 나무의 개수만큼 cnt 높이기)
		long N = Long.parseLong(st1.nextToken());
		long M = Long.parseLong(st1.nextToken());
		// 나무들 중 가장 높은 나무의 크기
		long max = 0;
		for (long i = 0; i < N; i++) {
			long size = Long.parseLong(st2.nextToken());
			wood.add(size);
			if (size > max) {
				max = size;
			}
		}

		long left = 1;
		long right = max;
		long sum = 0;
		long mid = 0;
		while (left <= right) {
			sum = 0;
			mid = (left + right) / 2;
			for (int i = 0; i < wood.size(); i++) {
				if (wood.get(i) > mid) {
					sum += (wood.get(i) - mid);
				}
			}
//			System.out.printf("%d %d %d sum : %d", left, mid, right, sum);
//			System.out.println();

			if (sum >= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		System.out.println(right);
	}

}
