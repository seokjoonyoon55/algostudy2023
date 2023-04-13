package study0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek16172_답봤는데틀림 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		char[] str = bfr.readLine().replaceAll("[0-9]", "").toCharArray();
		char[] pattern = bfr.readLine().toCharArray();

		// 타겟에서 최대경계 배열 만들기
		int[] maxBorder = new int[pattern.length + 1];
		//maxBorder[0] = -1;

		int idx = 0;
		// 길이에 따른 최대경계 채우기(이해못함)
		for (int len = 1; len < pattern.length; len++) {

			while (pattern[idx] != pattern[len] && idx > 0) {
				idx = maxBorder[idx];
			}

			if (pattern[idx] == pattern[len])
				maxBorder[len + 1] = ++idx;

		}
		System.out.println(Arrays.toString(maxBorder));

		int idxt = 0;
		boolean isExist = false;

		for (int idxs = 0; idxs < str.length; idxs++) {
			while (idxt > 0 && str[idxs] != pattern[idxt]) {
				idxt = maxBorder[idxt - 1];
			}
			if (str[idxs] == pattern[idxt]) {
				if (idxt == pattern.length - 1) {
					idxt = maxBorder[idxt];
					isExist = true;
					break;
				} else {
					
					idxt++;
				}
			}

		}

		if (isExist)
			System.out.println(1);
		else
			System.out.println(0);

	}
}

//https://loosie.tistory.com/768
