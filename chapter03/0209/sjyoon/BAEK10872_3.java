package chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK10872_3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		br.close();
		
		int val = 1;
		
		
		for (int i=1;i<=N;i++) {
			val=val*i;
		}
		
		System.out.println(val);
	}
}
