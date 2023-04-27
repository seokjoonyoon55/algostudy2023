import java.util.Scanner;

public class Baek_17419 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		int N = Integer.parseInt(sc.nextLine());
		
		String[] arr = sc.nextLine().split("");
		
		int num = 0;
		
		
		for (int i=0;i<N;i++) {
			if (arr[i].equals("1")) {
				num += Math.pow(2, arr.length-i-1);
			}
		}
		*/
		
		
		int N = Integer.parseInt(sc.nextLine());
		
		
		Long num = (long) Integer.parseInt(sc.nextLine(),2);
		
		
		int cnt = 0;
		
		while (num != 0) {
			num = num - (num & ((~num) + 1));
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
