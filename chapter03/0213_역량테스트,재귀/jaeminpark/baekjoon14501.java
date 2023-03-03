package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon14501 {

	static int N;
	static int[] days;
	static boolean[] isUsed;
	static int[] answer;
	static List<int[]> daysList = new ArrayList<>();
	static int indexNotZero;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		days = new int[N];
		answer = new int[N];
		isUsed = new boolean[N];
		StringTokenizer st;
		// 상담 기간 저장
		List<Integer> list = new ArrayList<>();
		// 상담 수익 리스트
		List<Integer> money = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(p);
			money.add(b);
			days[i] = p;
		}

		// 남은 일수보다 상담 소요기간이 긴 경우 0으로 치환(1부터 시작됨)
		for (int i = 0; i < N; i++) {
			if (list.get(i) > list.size() - i) {
				list.set(i, 0);
				money.set(i, 0);
				isUsed[i] = true;
				days[i] = 0;
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			if (list.get(i) != 0) {
				indexNotZero = i;
				break;
			}
		}
		System.out.println(list);
		System.out.println(money);
		System.out.println(Arrays.toString(days));
		System.out.println(Arrays.toString(isUsed));

		System.out.println(indexNotZero);

		counsel(0);

		System.out.println("--------------------------");
		for (int i = 0; i < daysList.size(); i++) {
			System.out.println(Arrays.toString(daysList.get(i)));
		}
		System.out.println("--------------------------");

		bw.flush();
		bw.close();

	}

	static void counsel(int depth) {
		System.out.println("----------------------------");
		if (depth == N) {
			System.out.println("95 answer: " + Arrays.toString(answer));
			answer = new int[N];
			return;
		}
		System.out.println("depth: " + depth);
		for (int i = 0; i <= indexNotZero; i++) {
			System.out.println("days : " + days[i]);
			if (!isUsed[i]) {
				for (int j = 0; j < N; j++) {
					isUsed[i] = true;
				}
				answer[i] = days[i];
				counsel(i + days[i]);
				for (int j = 0; j < N; j++) {
					isUsed[i] = true;
				}
			}
		}
		System.out.println("=================================");
	}
}
