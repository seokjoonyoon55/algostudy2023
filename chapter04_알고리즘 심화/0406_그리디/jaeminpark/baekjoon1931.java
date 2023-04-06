package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1931 {

	public static class time implements Comparable<time> {
		int from, to, howLong;

		time(int from, int to, int howLong) {
			this.from = from;
			this.to = to;
			this.howLong = howLong;
		}

		@Override
		public String toString() {
			return "time [from=" + from + ", to=" + to + ", howLong=" + howLong + "]";
		}

		@Override
		public int compareTo(time o) {
			if (to != o.to) {
				return to - o.to;
			} else {
				return from - o.from;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		time[] timeTable = new time[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 얘는 안씀
			int howLong = to - from;
			timeTable[i] = new time(from, to, howLong);
		}
		Arrays.sort(timeTable);
		int cnt = 0;
		// 마지막 회의 끝나는 시간
		int until = 0;
		for (int i = 0; i < N; i++) {
			if (until <= timeTable[i].from) {
				until = timeTable[i].to;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
