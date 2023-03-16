package barkingdog;

import java.util.Arrays;
import java.util.Scanner;

public class Baek2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];

		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 이분탐색을 위한 오름차순 정렬
		Arrays.sort(arr);
		long end = arr[N-1];
		long start = 0;
	
		while(start <= end) {
			long middle = (start + end) / 2;
			int sum = 0;
			// 중간값보다 배열값이 더 크다면 나무 자르기
			for(int a : arr) {
				if(a > middle) {
					sum += a - middle;
				}
			}
			// 나무 자른 길이가 최소 필요한 길이 M보다 크다면
			// 높이를 올려서 잘려나가는 나무의 길이를 줄여야함
			if(sum >= M) start = middle + 1;
			else end = middle - 1;
		}
		System.out.println(end);
	}
}
