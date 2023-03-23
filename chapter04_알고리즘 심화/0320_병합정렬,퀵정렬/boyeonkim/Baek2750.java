package barkingdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2750 {
	public static int N;
	public static int[] arr;
	public static int[] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		temp = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(0, N - 1);
		printArr(arr);
		
	}
	// start는 mergeSort를 진행할 배열의 시작 인덱스, end는 배열의 마지막 인덱스
	public static void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			
			// 두 분할의 첫 번째 원소 인덱스 p, q에 각각 저장
			int p = start;
			int q = mid + 1;
			// 분할의 저장 위치 인덱스
			int idx = start;
			
			// p가 mid이하이거나 q가 end이하일 때만 작동해야함
			while(p <= mid || q <= end) {
				// 첫 번째 분할에서 원소를 가지고 오는 경우
				// 1. 두 번째 분할의 원소를 이미 다 가져온 경우
				// 2. 첫 번째 분할에서 가지고 오지 않은 원소가 있고
				// 첫 번째 분할의 첫 원소 값이 두 번째 분할의 첫 원소 값보다 작은 경우
				if(q > end || (p <= mid && arr[p] < arr[q])) {
					temp[idx++] = arr[p++];
				} else { // 그렇지 않으면 두 번째 분할에서 원소를 가지고 온다
					temp[idx++] = arr[q++];
				}
			}
			// 1번 분할과 2번 분할의 모든 원소를 가지고 오면 정렬된 값을 기존 배열에 저장
			for(int i = start; i <= end; i++) {
				arr[i] = temp[i];
			}
		}
	}
	
	public static void printArr(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
}
