package study0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//못함
public class Baek10814 {
	static int[] arr;
	static int[] age;
	static String[] name;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bfr.readLine());

		age = new int[N];
		name = new String[N];
		String[] AN = new String[2];

		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i;

		// 입력받기
		for (int i = 0; i < N; i++) {
			AN = bfr.readLine().split(" ");
			age[i] = Integer.parseInt(AN[0]);
			name[i] = AN[1];
		}

		quickSort(0, N - 1);

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void quickSort(int start, int end) {
		if (start == end)
			return;

		int pivot = start;
		int idxL = start + 1;
		int idxR = end;

		while (idxL < idxR) {
			while (idxL <= end && age[idxL] <= age[pivot]) {
				if (age[idxL] == age[pivot] && arr[idxL] > arr[pivot])
					break;
				idxL++;
			}

			while (idxR >= start && age[pivot] <= age[idxR]) {
				if (age[pivot] == age[idxR] && arr[pivot] < arr[idxR])
					break;
				idxR--;
			}

			swap(idxL, idxR);
			idxL++;
			idxR--;

		}

		swap(idxR, pivot);

		quickSort(start, idxR - 1);
		quickSort(idxR + 1, end);
	}

	public static void swap(int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}
