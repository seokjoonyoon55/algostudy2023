package study230116;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class swea1966 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			ArrayList<Integer> List = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				List.add(sc.nextInt());
			}
			// System.out.println(List);
			Collections.sort(List);
			System.out.print("#" + test_case);
			for (int j = 0; j < List.size(); j++) {
				System.out.print(" " + List.get(j));
			}
			System.out.println("");
		}
	}
}
