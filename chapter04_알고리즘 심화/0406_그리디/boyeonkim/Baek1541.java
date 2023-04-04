package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 예시 : 55-50+40-20+50-10
		
		// - 를 기준으로 쪼개서 str 배열에 담기
		// [55, 50+40, 20+50, 10]
		String[] str = br.readLine().split("-");
		int res = 0; // 결과 저장할 변수
		
		for(int i = 0; i < str.length; i++) {
			int num = 0;
			// +를 기준으로 쪼개서 add 배열에 담아주기
			// [50, 40]
			String[] add = str[i].split("\\+");
			// add 배열에 있는 값 전체 더하기
			for(int j = 0; j < add.length; j++) {
				num += Integer.parseInt(add[j]);
			}
			// 첫번째 오는 숫자는 무조건 + 이니까 그대로 결과 변수에 저장
			if(i == 0) res = num;
			// 두번째 숫자부터는 -
			else res -= num;
		}
		System.out.println(res);
	}
}
