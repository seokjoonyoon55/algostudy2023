package study0209;

import java.util.Scanner;

public class Baek10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibo(N));
	}
	
	public static int fibo(int n) {
		int res;
		
		if(n==0) res=0;//0일때 0반환
		else if(n==1) res=1;//1일때 1반환
		else res=fibo(n-1)+fibo(n-2);//2이상일 때 피보나치 식 그대로
		
		return res;
	}
}
//12888KB	116ms