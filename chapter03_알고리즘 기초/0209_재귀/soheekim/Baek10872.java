package study0209;

import java.util.Scanner;

public class Baek10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(factorial(N));
	}

	public static int factorial(int num) {
		int res;//반환 결과 저장 임시변수
		if (num == 0)
			res = 1;//0일때 결과값 1
		else
			res = num * (factorial(num - 1));//0이 아닐 때 재귀로 곱해가기

		return res;
	}
}
//메모리 12820kb 시간 116ms