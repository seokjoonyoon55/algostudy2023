package study0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2750 {
	static int[] arr;// 숫자 저장 배열
	static Queue<Integer> quu = new LinkedList<>();// 병합정렬 시 사용하는 큐

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 숫자 갯수
		int N = Integer.parseInt(bfr.readLine());

		// 숫자 저장할 배열
		arr = new int[N];

		// 숫자들 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
		}

		// 0부터 N-1인덱스 사이의 병합정렬 실행
		mergeSort(0, N - 1);

		//출력
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

	// 인덱스 start 부터 end 정렬 실행
	public static void mergeSort(int start, int end) {
		// 시작==끝 이면 메서드 종료
		if (start == end)
			return;

		int mid = (start + end) / 2;// 중간지점
		int idxL = start;// 왼쪽 더미 시작 인덱스
		int idxR = mid + 1;// 오른쪽 더미 시작 인덱스

		// 왼쪽, 오른쪽 각각 병합정렬 실행
		mergeSort(start, mid);
		mergeSort(mid + 1, end);

		//
		while (idxL <= mid || idxR <= end) {
			// 왼쪽 다 썼으면
			if (idxL > mid) {
				// 오른쪽 남은 것을 큐에 넣고 오른쪽 포인터++
				quu.add(arr[idxR++]);
				continue;
			}

			// 오른쪽 다 썼으면
			if (idxR > end) {
				// 왼쪽 남은 것을 큐에 넣고 왼쪽 포인터 ++
				quu.add(arr[idxL++]);
				continue;
			}

			// 왼쪽 포인터의 배열값 < 오른쪽 포인터의 배열값이면
			if (arr[idxL] < arr[idxR])
				// 오른쪽꺼 배열에 넣고 포인터++
				quu.add(arr[idxL++]);
			// 왼쪽 포인터의 배열값 > 오른쪽 포인터의 배열값이면
			else if (arr[idxL] > arr[idxR])
				// 왼쪽꺼 배열에 넣고 포인터++
				quu.add(arr[idxR++]);
		}

		//정렬되어 큐에 들어간 것들을 원래 배열로 넣어줌
		for (int idx = start; idx <= end; idx++) {
			arr[idx] = quu.poll();
		}

	}

}
