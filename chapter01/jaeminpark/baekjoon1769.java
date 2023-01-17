package baekjoonPractice;

import java.util.*;

public class baekjoon1769 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String X = sc.next();
		int num = 0; // while문이 반복되는 횟수를 저장하기 위한 변수
		while (X.length() > 1) { // X의 자릿수가 1의 자리가 될때까지 반복(1의 자리가 되면 반복문 탈출)
			int sum = 0; // 각 자리 수를 더해서 저장할 변수
			String[] x = X.split(""); // x라는 배열에 X의 각자리를 잘라서 저장

			for (String i : x) {
				sum += Integer.parseInt(i); // x는 String 타입이기 때문에 Integer타입으로 변환해서 sum에 그 값 저장
			}
			X = Integer.toString(sum); // 처음에 X를 String으로 받았기 때문에(split 이용해서 자리수 짜르기 위해) 다시 String으로 타입 변환
			num++; // while문이 반복되는 횟수 num에 저장
		}
		System.out.println(num); // while문이 반복되는 횟수 출력(num)
		if (Integer.parseInt(X) % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
