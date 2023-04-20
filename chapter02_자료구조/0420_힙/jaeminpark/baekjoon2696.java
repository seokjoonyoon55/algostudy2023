package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class baekjoon2696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 출력 형식 맞추기 위함
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			// 홀수번째마다 출력하므로 총 개수의 절반 +1 만큼 숫자가 나옴
			sb.append(N / 2 + 1).append("\n");
			// treeMap 이용(숫자, 해당 숫자의 개수)
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			// 한줄에 10개씩 출력해야 하므로 StringBuilder에 10개 붙일때마다 개행 추가
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 10 == 1) // 한줄에 10개 있으므로 10개마다 StringTokenizer 받아와야 함
					st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				tm.put(num, tm.getOrDefault(num, 0) + 1);
				// 홀수번째 마다 중간값 붙여야 함
				if (i % 2 != 0) {
					// 총 개수의 합(value의 합)
					// 총 개수가 나온 숫자들의 개수(i)의 절반+1보다 크거나 같아지면 해당 값이 중간값임
					int sum = 0;
					for (int key : tm.keySet()) {
						sum += tm.get(key);
						if (sum > i / 2) {
							sb.append(key).append(" ");
							cnt++;
							if (cnt == 10) {
								sb.append("\n");
								cnt = 0;
							}
							break;
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
