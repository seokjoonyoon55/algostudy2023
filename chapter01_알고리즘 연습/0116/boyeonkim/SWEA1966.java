import java.util.Scanner;
import java.util.Arrays;

public class swea04{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for(int i = 1; i <= a; i++){
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int b = 0; b < n; b++){
				arr[b] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.print("#"+i);
			for(int b = 0; b < arr.length; b++){
				System.out.print(" "+arr[b]);
			}
			System.out.println();
		}
	}
}