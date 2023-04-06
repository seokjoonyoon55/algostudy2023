package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1931 {
	static class Meeting implements Comparable<Meeting> {
		int start, end, length;

		public Meeting(int start, int end, int length) {
			super();
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public String toString() {
			return "[" + start + ", " + end + ", " + length + "]";
		}

		//끝시간 우선 정렬, 끝시간 같으면 시작시간 적은거 우선정렬
		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end)
				return this.start - o.start;
			return this.end - o.end;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		//회의 담을 우선순위 큐
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		
		//회의 갯수
		int N = Integer.parseInt(bfr.readLine());

		//회의 정보 받기
		String[] tempS;
		for (int i = 0; i < N; i++) {
			tempS = bfr.readLine().split(" ");
			int start = Integer.parseInt(tempS[0]);
			int end = Integer.parseInt(tempS[1]);
			int length = end - start;
			pq.add(new Meeting(start, end, length));
		}

		int cnt = 0;//가능한 회의 수
		int time = 0;//현재 시점
		Meeting tempM;//임시변수

		while (!pq.isEmpty()) {
			//큐에서 꺼내기
			tempM = pq.poll();
			
			//꺼낸 회의가 현재 시점 이전에 시작하는 거면 continue;
			if (time > tempM.start)
				continue;

			//가능한 회의수 ++, 회의 끝나는 시간으로 시점 갱신
			cnt++;
			time = tempM.end;
		}
		
		//출력
		System.out.println(cnt);
	}
}
