package baekjoon_01_Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon25501 {

	public static int cnt = 0;

	public static int[] recursion(String s, int l, int r) {
		cnt++;
		int[] rtn = new int[2];
		if (l >= r) {
			rtn[0] = 1;
			rtn[1] = cnt;
			return rtn;
		} else if (s.charAt(l) != s.charAt(r)) {
			rtn[0] = 0;
			rtn[1] = cnt;
			return rtn;
		} else
			return recursion(s, l + 1, r - 1);
	}

	public static int[] isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		String s;
		for (int i = 0; i < T; i++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			int[] arr = isPalindrome(s);
			sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
		}
		System.out.println(sb);
	}

}
