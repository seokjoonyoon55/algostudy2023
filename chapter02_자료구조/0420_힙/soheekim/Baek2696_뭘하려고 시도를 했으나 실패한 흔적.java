package study0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baek2696 {
	static boolean isodd = true;

	static class Node implements Comparable<Node> {
		int num;

		public Node(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			return isodd ? this.num - o.num : o.num - this.num;
		}

		@Override
		public String toString() {
			return "[" + num + "]";
		}
		

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(bfr.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bfr.readLine());
			PriorityQueue<Node> pq = new PriorityQueue<>();

			int[] arr = new int[N];
			int pnt = 0;

			// 수 입력받기
			while (true) {
				String[] tempS = bfr.readLine().split(" ");
				for (int j = 0; j < tempS.length; j++) {
					arr[pnt++] = Integer.parseInt(tempS[j]);
				}

				if (pnt == N)
					break;

				if (tempS.length != 10)
					break;
			}

			System.out.println(Arrays.toString(arr));
			// 수 입력받기 끝

			for (int i = 0; i < N; i++) {
				pq.add(new Node(arr[i]));
				if(isodd)
					System.out.println(pq.peek());
				isodd = !isodd;
			}

		}
	}
}
