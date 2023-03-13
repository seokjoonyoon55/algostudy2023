package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1991 {

	public static class point {

		char c;
		char left;
		char right;

		point(char c, char left, char right) {
			this.c = c;
			this.left = left;
			this.right = right;
		}
	}

	static int N;
	static point[] points;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static void preorder_traverse(int T) {
		if (!visited[T]) {
			visited[T] = true;
			sb.append(points[T].c);
			if (points[T].left != '.') {
				int t = 0;
				for (int i = 1; i <= N; i++) {
					if (points[i].c == points[T].left) {
						t = i;
						break;
					}
				}
				preorder_traverse(t);
			}
			if (points[T].right != '.') {
				int t = 0;
				for (int i = 1; i <= N; i++) {
					if (points[i].c == points[T].right) {
						t = i;
						break;
					}
				}
				preorder_traverse(t);
			}
		}
	}

	static void inorder_traverse(int T) {
		if (!visited[T]) {
			if (points[T].left != '.') {
				int t = 0;
				for (int i = 1; i <= N; i++) {
					if (points[i].c == points[T].left) {
						t = i;
						break;
					}
				}
				inorder_traverse(t);
			}
			visited[T] = true;
			sb.append(points[T].c);
			if (points[T].right != '.') {
				int t = 0;
				for (int i = 1; i <= N; i++) {
					if (points[i].c == points[T].right) {
						t = i;
						break;
					}
				}
				inorder_traverse(t);
			}
		}
	}

	static void postorder_traverse(int T) {
		if (!visited[T]) {
			if (points[T].left != '.') {
				int t = 0;
				for (int i = 1; i <= N; i++) {
					if (points[i].c == points[T].left) {
						t = i;
						break;
					}
				}
				postorder_traverse(t);
			}
			if (points[T].right != '.') {
				int t = 0;
				for (int i = 1; i <= N; i++) {
					if (points[i].c == points[T].right) {
						t = i;
						break;
					}
				}
				postorder_traverse(t);
			}
			visited[T] = true;
			sb.append(points[T].c);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		points = new point[N + 1];
		char c = 'A';
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			points[i] = new point(c, left, right);
		}
		visited = new boolean[N + 1];
		preorder_traverse(1);
		sb.append("\n");
		visited = new boolean[N + 1];
		inorder_traverse(1);
		sb.append("\n");
		visited = new boolean[N + 1];
		postorder_traverse(1);
		System.out.println(sb);
	}

}
