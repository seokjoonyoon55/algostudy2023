package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK17419 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String binary = br.readLine();
		int cnt = 0;
		for (int i = 0; i < binary.length(); i++) {
			// 연산 자체가 1의 개수만 세면 됨.
			if (binary.charAt(i) == '1') cnt++;
		}
		System.out.println(cnt);
	}
}
