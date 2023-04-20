package study0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1927_3 {
	static int[] heap;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(bfr.readLine());
		heap = new int[2 * N + 2];
		int rearIdx = 1;
		int pointer = -1;

		for (int line = 0; line < N; line++) {
			int order = Integer.parseInt(bfr.readLine());

			switch (order) {
			case 0:
				
				sb.append(heap[1]).append("\n");
				if (heap[1] == 0)
					continue;

				heap[1] = heap[rearIdx - 1];
				heap[rearIdx - 1] = 0;
				pointer = 1;
				rearIdx--;
				//System.out.println(Arrays.toString(heap)+ " rear "+ rearIdx);// test
				while (pointer * 2 < rearIdx || pointer * 2 + 1 < rearIdx) {
					int tchildIdx = -1;
					if (pointer * 2 + 1 < rearIdx) {
						if(heap[pointer * 2] < heap[pointer * 2 + 1])
							tchildIdx=pointer*2;
						else
							tchildIdx=pointer*2+1;
					}
					else {
						if(pointer*2<rearIdx)
							tchildIdx=pointer*2;
					}
					
					if(tchildIdx==-1)
						break;
					else {
						if(heap[pointer]>heap[tchildIdx])
						swap(pointer, tchildIdx);
						pointer=tchildIdx;
						//System.out.println(Arrays.toString(heap) + " rear "+ rearIdx);// test
						continue;
					}
				}
				//System.out.println("end");
				break;
			default:
				//System.out.println("input start");
				heap[rearIdx++] = order;
				pointer = rearIdx - 1;
				//System.out.println(Arrays.toString(heap));// test
				while (pointer / 2 > 0 && heap[pointer / 2] > heap[pointer]) {
					if (heap[pointer] != 0) {
						swap(pointer / 2, pointer);
						pointer /= 2;
						//System.out.println(Arrays.toString(heap)+ " rear "+ rearIdx);// test
					} else
						break;
				}
				//System.out.println("end");
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
