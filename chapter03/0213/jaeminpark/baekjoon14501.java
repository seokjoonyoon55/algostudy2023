package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
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
		}

		// 남은 일수보다 상담 소요기간이 긴 경우 0으로 치환(1부터 시작됨)
		for (int i = 0; i < N; i++) {
			if (list.get(i) > list.size() - i) {
				list.set(i, 0);
				money.set(i, 0);
			}
		}
		System.out.println(list);
		System.out.println(money);
		int index = 0;
		int sum = 0;
		int max = 0;
		while (index < list.size()) {

			int innerIndex = index;
			sum += list.get(index);
			loop: while (innerIndex<list.size()) {
				int maxIndex = 0;
				for (int i = innerIndex; i < innerIndex + list.get(innerIndex); i++) {
					if (money.get(i) > money.get(maxIndex)) {
						maxIndex = i;
					}
				}
				sum += money.get(maxIndex);
				if (maxIndex > innerIndex) {
					for (int i = innerIndex; i < maxIndex; i++) {
						if (i + list.get(i) > maxIndex) {
							list.set(i, 0);
							money.set(i, 0);
						}
					}
					continue loop;
				} else {
					innerIndex += maxIndex + list.get(maxIndex);
				}
			}
			if (sum > max) {
				max = sum;
			}
			index++;
			System.out.println("sum: " + sum);
		}
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();

	}

}
