package study0316;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//시간초과
public class Baek10816 {
	static LinkedList<Integer> nums = new LinkedList<Integer>();
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

		for (int i = 0; i < M; i++) {
			int leftIdx = binSearchLeft(0, N - 1, targets[i]);
			int rightIdx = binSearchRight(0, N - 1, targets[i]);

			sb.append(rightIdx - leftIdx + 1).append(" ");
		}

		System.out.println(sb);

		sc.close();

	}

	public static int binSearchLeft(int startIdx, int endIdx, int target) {
		int mid = -2;
		int start = startIdx;
		int end = endIdx;

		while (start < end) {
			mid = (start + end) / 2;
			if (nums.get(mid) > target)
				end = mid;
			else if (nums.get(mid) < target)
				start = mid + 1;
			else if (nums.get(mid) == target)
				end = mid;
		}
		return start;
	}

	public static int binSearchRight(int startIdx, int endIdx, int target) {
		int mid = -2;
		int start = startIdx;
		int end = endIdx;

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
