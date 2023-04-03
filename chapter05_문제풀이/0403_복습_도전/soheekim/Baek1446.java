package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1446 {
	// 지름길 클래스
	static class Road implements Comparable<Road> {
		// 지름길 시작점, 끝점, 지름길 길이
		int start, end, length;

		public Road(int start, int end, int length) {
			super();
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(Road o) {
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "[ " + this.start + ", " + this.end + ", " + this.length + " ]";
		}

	}

	static PriorityQueue<Road> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		// ND 입력받기
		String[] ND = bfr.readLine().split(" ");
		int N = Integer.parseInt(ND[0]);// 지름길 갯수
		int D = Integer.parseInt(ND[1]);// 고속도로 길이

		// 지름길 시작점, 끝점, 길이 입력받는 용 변수
		String[] SEL;
		int start, end, length;

		// 지름길 정보 입력받기
		for (int lines = 1; lines <= N; lines++) {
			SEL = bfr.readLine().split(" ");
			start = Integer.parseInt(SEL[0]);
			end = Integer.parseInt(SEL[1]);
			length = Integer.parseInt(SEL[2]);
			
			//지름길이 원래보다 짧고, 도착점을 넘지 않으면 입력 받아서 우선큐에 입력하기
			if (end - start > length && D >= end) {
				Road tempR = new Road(start, end, length);
				pq.add(tempR);
			}
		}

		//0지점에서 시작하고, 현재 절약된 거리가 0인 상태로 메서드 시작
		int res = calLength(0, 0);
		
		//고속도로 길이 - 절약된 최대길이 출력
		System.out.println(D - res);

	}

	//현재 위치와 지금까지 절약한 거리 전달하면 다음 절약 계산하는 메서드
	static int calLength(int curPos, int saveLength) {
		// 우선큐 비어있으면(더이상 계산할 지름길이 없으면) 바로 리턴
		if (pq.isEmpty())
			return saveLength;

		//현재 절약된 길이 초기화
		int curLength = saveLength;
		
		// 우선큐 안비어있으면 뽑기
		Road tempR = pq.poll();

		//뽑은 지름길 시작점이 현재보다 뒤면 절약 길이 계산
		if (curPos <= tempR.start) {
			curLength = Math.max(curLength, calLength(tempR.end, saveLength + tempR.end - tempR.start - tempR.length));
		}

		//지름길 안 간 상태로의 절약 길이 계산
		curLength = Math.max(curLength, calLength(curPos, saveLength));
		
		//뽑은 지름길 다시 큐에 되돌리기
		pq.add(tempR);
		
		//계산 결과 반환
		return curLength;
	}
}
