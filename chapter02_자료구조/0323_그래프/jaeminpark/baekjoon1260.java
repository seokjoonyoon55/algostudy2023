package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class baekjoon1260 {

	static int N;
	static int M;
	static boolean[] isVisited;
	static Vector<Integer>[] line;
	static int[] answer;
	static int cnt = 0;
	static int index = 0;
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int startIndex = Integer.parseInt(st.nextToken()) - 1;
		answer = new int[N];
		isVisited = new boolean[N];
		line = new Vector[N];

		for (int i = 0; i < N; i++) {
			line[i] = new Vector<>();
		}
		int start;
		int end;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			line[start - 1].add(end - 1);
			line[end - 1].add(start - 1);
		}

		for (int i = 0; i < N; i++) {
			if (line[i].size() == 0) {
				isVisited[i] = true;
			} else {
				cnt++;
			}
		}
		for (int i = 0; i < N; i++) {
			Collections.sort(line[i]);
		}
//		System.out.println(Arrays.toString(line));
		q.offer(startIndex);
		isVisited[startIndex] = true;
		dfs(1, startIndex);

		while (!q.isEmpty()) {
			sb.append(q.remove() + 1).append(" ");
		}
		sb.append("\n");

		answer = new int[N];
		isVisited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (line[i].size() == 0) {
				isVisited[i] = true;
			} else {
				cnt++;
			}
		}
		bfs(startIndex);
		for (int i = 0; i < N; i++) {
			if (answer[i] == 0) {
				break;
			}
			sb.append(answer[i]).append(" ");
		}
//		System.out.println(Arrays.toString(answer));
		System.out.println(sb);
	}

	// 깊이 우선
	static void dfs(int depth, int startIndex) {
		if (depth == N) {
			return;
		}
		for (int i = 0; i < line[startIndex].size(); i++) {
			if (!isVisited[line[startIndex].get(i)]) {
				isVisited[line[startIndex].get(i)] = true;
				q.offer(line[startIndex].get(i));
				dfs(depth + 1, line[startIndex].get(i));
			}
		}
	}

	// 너비 우선
	static void bfs(int startIndex) {
		answer[index++] = startIndex + 1;
		isVisited[startIndex] = true;
		q.offer(startIndex);
		while (!q.isEmpty()) {
			int k = q.remove();
			for (int i = 0; i < line[k].size(); i++) {
				int x = line[k].get(i);
				if (!isVisited[x]) {
					isVisited[x] = true;
					q.offer(x);
					answer[index++] = x + 1;
				}
			}
		}

	}

}
