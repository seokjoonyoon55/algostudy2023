package practice01;
//import java.util.Scanner;

public class swea1926 {

	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
		int N = 67;
		int temp;
		int printif0;
		for(int i=1; i<=N;i++) {
			temp=i;
			printif0=0;
			while(temp>1) {
				if((temp%10!=0)&&((temp%10)%3 == 0)) {
					System.out.format("-");
					printif0=1;
				}
				temp=temp/10;
			}
			if(printif0==0)System.out.print(i);
			if(i!=N)System.out.print(" ");
		}
//		sc.close();
	}
}
