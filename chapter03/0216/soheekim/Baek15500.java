package study0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek15500 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bfr.readLine());

		
		String[] disk = bfr.readLine().split(" ");
		int[] diskInt = new int[N];	
		
		// 원판 입력받아서 저장
		for (int i = 0; i < N; i++) {
			diskInt[i] = Integer.parseInt(disk[i]);
		}

		

	}

	public static void findmove(int target, int start, int mid, int end) {

		
		
		
		
	}

	
	public static void moveto() {}
}
