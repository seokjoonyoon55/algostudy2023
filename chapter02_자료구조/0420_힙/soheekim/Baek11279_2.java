package study0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek11279_2 {
	static int[] heap;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(bfr.readLine());// 오더 갯수
		heap = new int[2 * N + 2];// 힙으로 쓸 완전이진트리배열
		int rearIdx = 1;// 맨 뒤에 빈 인덱스 포인터
		int pointer = -1;// 스왑용 포인터

		// N개 오더 반복
		for (int line = 0; line < N; line++) {
			// 오더 받음
			int order = Integer.parseInt(bfr.readLine());

			switch (order) {
			// 오더가 0일때 출력
			case 0:
				// 루트 sb에 저장(출력)
				sb.append(heap[1]).append("\n");

				// 루트==0 빈 힙이라면 다음오더로 넘어감
				if (heap[1] == 0)
					continue;

				// 맨 뒤 리프노드 위로 올리고 맨 뒤 리프노드 비움
				heap[1] = heap[rearIdx - 1];
				heap[rearIdx - 1] = 0;

				pointer = 1;// 정렬용 포인터
				rearIdx--;// 맨뒤 노드 포인터--

				// 스왑 고려 가능한 노드가 있는동안 반복
				while (pointer * 2 < rearIdx || pointer * 2 + 1 < rearIdx) {
					// 스왑목표 자식노드의 인덱스. 선언 및 초기화
					int tchildIdx = -1;

					// 오른쪽 자식이 있으면
					if (pointer * 2 + 1 < rearIdx) {
						// 왼자식 값>오른자식 값이면
						if (heap[pointer * 2] > heap[pointer * 2 + 1])
							// 왼자식을 스왑타겟으로
							tchildIdx = pointer * 2;
						// 왼자식 값<오른자식 값이면
						else
							// 오른자식을 스왑타겟으로
							tchildIdx = pointer * 2 + 1;
					}
					// 오른쪽 자식이 없으면
					else {
						// 왼쪽 자식은 있으면
						if (pointer * 2 < rearIdx)
							// 왼자식을 스왑타겟으로
							tchildIdx = pointer * 2;
					}

					// 자식이 없는 상태이면 반복 종료
					if (tchildIdx == -1)
						break;
					// 자식이 있으면
					else {
						// 현재값<자식값 이면 교환
						if (heap[pointer] < heap[tchildIdx])
							swap(pointer, tchildIdx);
						
						//고려중 포인터를 옮김. 현재값>자식값이라면 아래 노드들 검사 후 종료됨(따로 처리하면 시간 절약 가능할 듯?)
						pointer = tchildIdx;
						continue;
					}
				}
				break;
			//숫자 입력 명령이면
			default:
				//마지막 노드에 숫자 추가 후 맨뒤 빈칸 포인터++
				heap[rearIdx++] = order;
				
				//정렬용 포인터 리셋
				pointer = rearIdx - 1;
				
				//올라갈 부모가 남아있고 && 부모값<자식값 인 동안 반복해서 올림
				while (pointer / 2 > 0 && heap[pointer / 2] < heap[pointer]) {
					//다 올려서 0번인덱스의 0을 가리키기 전이면
					if (heap[pointer] != 0) {
						//부모 자식 스왑 후 부모로 포인터 옮김
						swap(pointer / 2, pointer);
						pointer /= 2;
					} else
						break;
				}
				break;
			}

		}
		System.out.println(sb);
	}

	public static void swap(int idxA, int idxB) {
		int temp;
		temp = heap[idxA];
		heap[idxA] = heap[idxB];
		heap[idxB] = temp;
	}
}
