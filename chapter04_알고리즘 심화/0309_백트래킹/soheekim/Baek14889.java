//package study0309;
//
//import java.util.Scanner;
//
//public class Baek14889 {
//	static int Astat = 0;
//	static int minDiff=Integer.MAX_VALUE;
//	static int sum=0;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[][] stats = new int[N][N];
//
//		int[] team = new int[N/2];
//		boolean[] used=new boolean[N];
//		
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				stats[r][c] = sc.nextInt();
//				sum+=stats[r][c];
//			}
//		}
//
//		chooseM(stats, team,0,0,N);
//		System.out.println(minDiff);
//		sc.close();
//	}
//
//	public static void chooseM(int[][] stats,boolean[] used, int start, int depth, int N) {
//		if (depth == N / 2) {
////			int[] teamA
//			
//			//test
//			for(int i=0;i<N/2;i++) {
//				System.out.print(team[i]+" ");
//			}
//			System.out.println();
//			
//			Astat=0;
//			int[] tempArr=new int[2];
//			calStat(stats,team,tempArr,0,N,0);
//			int diff=Math.abs(sum-2*Astat);
//			System.out.println("Astat "+Astat);
//			System.out.println("diff "+diff);
//			if(minDiff>diff)
//				minDiff=diff;
//			
//		} else {
//			for (int i = start; i < N; i++) {
//				
//				used[i] = true;
//				chooseM(stats, used,start+1,depth+1,N);
//				used[i]=false;
//			}
//		}
//	}
//
//	public static void calStat(int[][] stats, int[] member, int[] people, int start, int N,int depth) {
//
//		if (depth == 2) {
//			Astat += stats[people[0]][people[1]];
//			Astat += stats[people[1]][people[0]];
//			System.out.println();
//		} else {
//			for (int i = start; i < N/2; i++) {
//				people[depth] = member[i];
//				calStat(stats, member, people, i + 1, N,depth + 1);
//			}
//		}
//		return;
//	}
//}
