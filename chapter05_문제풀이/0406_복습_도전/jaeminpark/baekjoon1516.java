package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1516 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] indegree = new int[N + 1];
		int[] timeTakes = new int[N + 1];
		List<line>[] lines = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			lines[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			timeTakes[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int before = Integer.parseInt(st.nextToken());
				if (before == -1)
					break;
				lines[before].add(new line(before, i));
				indegree[i]++;
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		int[] answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.remove();
			for (line l : lines[cur]) {
				indegree[l.next]--;
				if (indegree[l.next] == 0)
					q.offer(l.next);
				// 여기가 이해가 안됨... 왜 최댓값?
				answer[l.next] = Math.max(answer[l.next], answer[cur] + timeTakes[cur]);
			}
		}
		for (int i = 1; i <= N; i++) {
			answer[i] += timeTakes[i];
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}

	static class line {
		int before;
		int next;

		line(int before, int next) {
			this.before = before;
			this.next = next;
		}

		@Override
		public String toString() {
			return "line [before=" + before + ", next=" + next + "]";
		}

	}

}
