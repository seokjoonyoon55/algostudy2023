package study0216;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek24444_2 {
	public static int vorder = 1;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		int tempx;
		int tempy;

		ArrayList<Integer>[] lines = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			lines[i] = new ArrayList<Integer>();
		}

		int[] node = new int[N];
		boolean[] isadded = new boolean[N];
		Queue<Integer> bfs = new LinkedList<Integer>();

		for (int i = 0; i < M; i++) {
			tempx = sc.nextInt() - 1;
			tempy = sc.nextInt() - 1;
			lines[tempx].add(tempy);
			lines[tempy].add(tempx);
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(lines[i]);
		}

		visit(lines, node, isadded, bfs, N, R - 1);

		for (int i = 0; i < N; i++) {
			System.out.println(node[i]);
		}

	}

	public static void visit(ArrayList<Integer>[] lines, int[] node, boolean[] isadded, Queue<Integer> bfs, int N,
			int R) {
		if (node[R] == 0) {
			node[R] = vorder++;
			for (int i = 0; i < lines[R].size(); i++) {
				if (node[lines[R].get(i)] == 0 && isadded[lines[R].get(i)] == false) {
					bfs.add(lines[R].get(i));
					isadded[lines[R].get(i)] = true;
				}
			}

			if (!bfs.isEmpty()) {
				R = bfs.poll();
				visit(lines, node, isadded, bfs, N, R);
			}
		}
	}
}