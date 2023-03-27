package study0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10972_3 {
	static int[] arr;//기존 배열
	static int[] arrNew;//새로 만든 배열
	static int N;//배열 크기
	static int pointer;//연산용 포인터

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bfr.readLine());// 최대 수
		StringBuilder sb = new StringBuilder();

		//기존 배열, 새 배열 할당
		arr = new int[N];
		arrNew = new int[N];

		//기존 배열 입력받기
		String[] tempS = bfr.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tempS[i]);
		}

		// 뒤에서부터 오름차순이 끝나는 지점을 찾음
		//맨 뒤에서 시작
		pointer = arr.length - 1;
		
		//오름차순이 끝날 때까지 pointer--
		while (pointer >= 0) {
			if (pointer - 1 < 0)
				break;
			if (arr[pointer - 1] > arr[pointer])
				pointer--;
			else
				break;
		}

		// 끝까지 진행했는데 못찾았다면 -1 출력 후 종료
		if (pointer - 1 < 0) {
			System.out.println(-1);
			return;
		}

		// pointer - 1이 목표숫자
		//목표숫자 다음부터 시작
		int pointer2 = pointer;
		
		// 목표숫자보다 작은값 찾을 때까지, 이전의 오름차순을 역으로 올라감
		while (pointer2 < arr.length) {
			if (arr[pointer - 1] < arr[pointer2])
				pointer2++;
			else
				break;
		}
		
		// 목표숫자 pointer-1 과 목표숫자 다음으로 큰 pointer-2을 스왑
		swap(pointer - 1, pointer2 - 1, arr);
		
		// 뒤쪽은 내림차순 정렬 상태이므로, 목표숫자까지는 그대로 옮기고, 목표숫자 이후부터는 거꾸로 옮김
		makeArr(pointer);

		//sb에 arrNew 담음
		for (int i = 0; i < N; i++) {
			sb.append(arrNew[i]).append(" ");
		}

		//출력
		System.out.println(sb);
	}

	// 두 자리 값 스왑
	public static void swap(int idx1, int idx2, int[] arr) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	// idx부터 뒤의 값을 반전시켜 저장함
	public static void makeArr(int idx) {
		int newIdx = 0;
		for (newIdx = 0; newIdx < idx; newIdx++) {
			arrNew[newIdx] = arr[newIdx];
		}

		for (int i = N - 1; i >= pointer; i--) {
			arrNew[newIdx++] = arr[i];
		}
	}

}