package study0313_Tree;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1991 {
	static int N;
	static String tree[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		tree = new String[27];
		
		tree[1] = "A";
		// N개의 노드와 자식 노드 입력받기
		// 각 노드의 알파벳이 있는 배열의 인덱스 * 2 = 왼쪽 노드, * 2 + 1 = 오른쪽 노드에 넣기
		for(int i = 1; i <= N; i++) {
			String[] str = sc.nextLine().split(" ");
			if(Arrays.asList(tree).indexOf(str[0]) * 2 + 1 < 27) {
				tree[Arrays.asList(tree).indexOf(str[0]) * 2] = str[1];
				tree[Arrays.asList(tree).indexOf(str[0]) * 2 + 1] = str[2];
			}
		}
		pre_traverse(1);
		System.out.println();
		in_traverse(1);
		System.out.println();
		post_traverse(1);
	}
	// 전위순회
	private static void pre_traverse(int i) {
		if(i <= 26) {
			if(tree[i] != null && !tree[i].equals("."))System.out.print(tree[i]);
			pre_traverse(i * 2);
			pre_traverse(i * 2 + 1);
		}
	}
	// 중위순회
	private static void in_traverse(int i) {
		if(i <= 26) {
			in_traverse(i * 2);
			if(tree[i] != null && !tree[i].equals("."))System.out.print(tree[i]);
			in_traverse(i * 2 + 1);
		}
	}
	// 후위순회
	private static void post_traverse(int i) {
		if(i <= 26) {
			post_traverse(i * 2);
			post_traverse(i * 2 + 1);
			if(tree[i] != null && !tree[i].equals("."))System.out.print(tree[i]);
		}
	}
}
