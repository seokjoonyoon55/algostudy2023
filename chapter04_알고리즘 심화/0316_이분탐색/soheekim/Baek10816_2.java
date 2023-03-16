package study0316;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baek10816_2 {
	// 숫자 및 목표숫자 저장용
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	static int[] targets;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();// 숫자 갯수
		sc.nextLine();// 개행 버림

		// 숫자들 입력받기
		// String으로 받은 후 int로 바꿔서 LinkedList에 저장
		String[] numString = sc.nextLine().split(" ");

		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(numString[i]));
		}

		int M = sc.nextInt();// 목표 숫자 갯수
		sc.nextLine();// 개행 버림

		// 목표들 입력받기
		// String으로 받은 후 int로 바꿔서 배열에 저장
		String[] targetString = sc.nextLine().split(" ");
		targets = new int[M];
		for (int i = 0; i < M; i++) {
			targets[i] = Integer.parseInt(targetString[i]);
		}

		// 숫자 정렬
		Collections.sort(nums);

		// 목표 숫자 M개에 대해
		for (int i = 0; i < M; i++) {
			// 목표 숫자가 위치한 가장 왼쪽, 가장 오른쪽 인덱스 계산
			int leftIdx = binSearchLeft(0, N - 1, targets[i]);
			int rightIdx = binSearchRight(0, N - 1, targets[i]);

			// 계산된 왼쪽 인덱스에 들은 값이 목표값과 일치하지 않으면 0
			// 1칸짜리 배열을 거르기 위한 조건 [2]에서 1찾기 등
			if (nums.get(leftIdx) != targets[i])
				sb.append("0 ");
			// 계산된 인덱스 값이 맞다면 오-왼+1로 숫자 갯수 찾기
			else
				sb.append(rightIdx - leftIdx + 1).append(" ");
		}

		// 출력
		System.out.println(sb);

		sc.close();

	}

	// 목표숫자가 있는 가장 왼쪽 인덱스 찾기
	public static int binSearchLeft(int startIdx, int endIdx, int target) {
		int mid = -2;// 중간지점
		int start = startIdx;// 시작점
		int end = endIdx;// 끝점

		while (start < end) {
			// 중간지점 계산
			mid = (start + end) / 2;

			// 중간지점의 값이 목표보다 크면
			if (nums.get(mid) > target)
				end = mid;
			// 중간 지점의 값이 목표보다 작으면
			else if (nums.get(mid) < target)
				start = mid + 1;
			// 중간지점의 값이 목표와 같으면
			else if (nums.get(mid) == target)
				end = mid;
		}
		return start;
	}

	//왜 됐는지 내가 이해 못하겠음...
	public static int binSearchRight(int startIdx, int endIdx, int target) {
		int mid = -2;// 중간지점
		int start = startIdx;// 시작점
		int end = endIdx;// 끝점

		while (start < end) {
			mid = (start + end) / 2 + 1;
			if (nums.get(mid) > target)
				end = mid - 1;
			else if (nums.get(mid) < target)
				start = mid;
			else if (nums.get(mid) == target)
				start = mid;
		}
		return start;
	}
}