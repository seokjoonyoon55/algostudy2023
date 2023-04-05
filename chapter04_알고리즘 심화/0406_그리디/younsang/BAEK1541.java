package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK1541 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int total = 0;
		// 일단 - 기호를 기준으로 split한다.
		String[] arr = str.split("-");
		for (int i = 0; i < arr.length; i++) {
			// arr 배열에서 제일 처음 인덱스에 있는 문자열(식)만 + 해주고
			if (i == 0) {
				String[] newArr = arr[i].split("\\+");
				int temp = 0;
				for (String s : newArr) {
					temp += Integer.parseInt(s);
				}
				total += temp;
			// 나머지는 전부 - 해주면 최솟값이 된다.
			} else {
				String[] newArr = arr[i].split("\\+");
				int temp = 0;
				for (String s : newArr) {
					temp += Integer.parseInt(s);
				}
				total -= temp;
			}
		}
		System.out.println(total);
	}
}