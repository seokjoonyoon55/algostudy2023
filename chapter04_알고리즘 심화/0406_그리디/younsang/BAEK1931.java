package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK1931 {
	static class MR implements Comparable<MR> {
		int start;
		int end;
		public MR(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		// 오름차순 정렬을 위해
		public int compareTo(MR o) {
			// 처음에 이 부분을 따로 구현안해줘서 85%에서 틀렸습니다.
			if (end == o.end) {
				return start - o.end;
			}
			return end - o.end;
		}
	}
	static int N;
	static List<MR> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new MR(start, end));
		}
		// 종료시간을 기준으로 정렬한다.
		Collections.sort(list);
		
		int cnt = 0;
		int end = 0;
		for (int i = 0; i < list.size(); i++) {
			// 첫 인덱스 일때는 종료시간을 end 변수에 초기화한다.
			if (i == 0) {
				cnt++;
				end = list.get(i).end;
			// 그 다음부터는 시작시간이 종료시간보다 크거나 같을 때만
			} else if (list.get(i).start >= end) {
				cnt++;
				end = list.get(i).end;
			}
		}
		System.out.println(cnt);
	}
}
