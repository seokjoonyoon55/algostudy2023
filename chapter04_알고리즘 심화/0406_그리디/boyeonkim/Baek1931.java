package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1931_회의실배정 {
	
	static class Node implements Comparable<Node>{
		int start, end;
		
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}

		// 끝나는 시간이 동일하다면 시작시간 기준으로 정렬
		// 다르다면 끝나는 시간 기준으로 정렬
		@Override
		public int compareTo(Node o) {
			return end == o.end ? start - o.start : end - o.end;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node nodes[] = new Node[N];
		
		// 노드에 시작시간과 끝시간 추가
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(start, end);
		}
		
		Arrays.sort(nodes);
		
		// 전 회의가 끝난 시간과 다음 회의의 시작시간이 일치하거나 그 후에 시작한다면
		// 다음회의의 끝나는 시간을 preEnd 변수에 재할당
		// 회의 횟수 증가
		int cnt = 0, preEnd = 0;
		for(int i = 0; i < N; i++) {
			Node curr = nodes[i];
			if(preEnd <= curr.start) {
				preEnd = curr.end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
