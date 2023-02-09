package chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK10870_2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		br.close();
		
		int val_ = 1;
		int val = 0;
		
		for (int i=0;i<n;i++) {
			val = val+val_;
			val_ = val+val_;
		}
		
		
		
		System.out.println(val);
		
	}
}
