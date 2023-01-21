package baekjoonPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon10773 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numList = new ArrayList<>();

		int K = sc.nextInt();
		int sum = 0;

		for (int i = 0; i < K; i++) {
			int a = sc.nextInt();
			if (a != 0) {
				numList.add(a);
			} else {
				numList.remove(numList.size()-1);
			}
		}

		for (int i = 0; i < numList.size(); i++) {
			sum += numList.get(i);
		}

		System.out.println(sum);
	}

}
