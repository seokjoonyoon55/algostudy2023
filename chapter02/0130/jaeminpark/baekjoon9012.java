package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String answer = "";
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			cnt = 0;
			for (int j = 0; j < str.length; j++) {
				if (j == 0 && str[j].equals(")")) {
					cnt = 100;
					break;
				} else if (j == N - 1 && str[j].equals("(")) {
					cnt = 100;
					break;
				} else if (str[j].equals("(")) {
					cnt++;
				} else if (str[j].equals(")")) {
					cnt--;
					if (cnt < 0) {
						cnt = 100;
						break;
					}
				}
			}

			if (cnt < 0 || cnt == 100) {
				answer = "NO";
			} else if (cnt > 0 && cnt < 100) {
				answer = "NO";
			} else if (cnt == 0) {
				answer = "YES";
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);

	}

}
