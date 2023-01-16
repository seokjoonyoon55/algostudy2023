package practice01;

import java.util.Scanner;

public class swea1954 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
		int T =1;
		for (int test_case=1;test_case<=T;test_case++) {
//			int N = sc.nextInt();
			int N=6;
			int[][] arr=new int[N][N];
			int i=0;
			int j=0;
			int status=0;//0 right, 1 down, 2 left, 3 up
			int step=0;
			int maxstep=N-1;
			for(int count=1;count<=N*N;count++) {
				if(step==maxstep) {
					if(status==3) {i++;j++;maxstep-=2;}
					status++;
					if(status==4)status=0;
					step=0;
					}
				arr[i][j]=count;
				
				switch (status) {
				case 0: j++;break;
				case 1: i++;break;
				case 2: j--;break;
				case 3: i--;break;
				default: System.out.print("error_status");
				}
				step++;
			}
			System.out.format("#%d\n",test_case);
			for (int x=0;x<N;x++) {
				for (int y=0;y<N;y++) {
					System.out.format("%d",arr[x][y]);	
					if(y!=N) System.out.print(" ");
				}
				System.out.println();
				if(x==N) System.out.println();
			}
		}
//		sc.close();
	}
}
