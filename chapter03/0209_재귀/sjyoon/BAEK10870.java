package chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK10870 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		br.close();
		
		int val = pib(n);
		
		System.out.println(val);
		
	}
	
	
	public static int pib(int n) {
		if (n<=1) return n;
		return pib(n-1) + pib(n-2);
	}
}
