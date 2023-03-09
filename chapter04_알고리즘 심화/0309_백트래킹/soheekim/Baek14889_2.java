package study0309;

import java.util.Scanner;

public class Baek14889_2 {
	static int Astat = 0;
	static int minDiff = Integer.MAX_VALUE;
	static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//인원수
		int[][] stats = new int[N][N];//능력치 저장용 배열

		boolean[] used = new boolean[N];//백트래킹에서 사람 선택됐는지 판단하는 배열

		//능력치 입력 받기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				stats[r][c] = sc.nextInt();
				sum += stats[r][c];
			}
		}

		//사람 선택
		chooseM(stats, used, 0, 0, N);

		System.out.println(minDiff);

		sc.close();
	}

	//사람 선택하는 메서드
	public static void chooseM(int[][] stats, boolean[] used, int start, int depth, int N) {
		//절반 선택했으면
		if (depth == used.length / 2) {
			//팀 배열 만들어줌
			int[] teamA = new int[used.length / 2];
			int[] teamB = new int[used.length / 2];

			//팀 배열에 넣은 사람 수
			int cntA = 0;
			int cntB = 0;

			//true라 사용됐으면 A팀, false면 B팀
			for (int i = 0; i < used.length; i++) {
				if (used[i])
					teamA[cntA++] = i;
				else
					teamB[cntB++] = i;
			}

			//두 팀 능력치 계산
			int statA = calStat(stats, teamA, new int[2], 0, 0);
			int statB = calStat(stats, teamB, new int[2], 0, 0);

			//능력치 차이 계산
			int diff = statA > statB ? statA - statB : statB - statA;
			
			//최소 능력치차이 갱신
			if(minDiff>diff)
				minDiff=diff;

		}
		//아직 다 선택되지 않았으면
		else {
			//시작점 start로 이전에 선택여부 따진 것들은 제외.
			for (int i = start; i < N; i++) {
				//0번이 선택되지 않았으면 종료. AB팀 구분이 필요없기 때문에.
				if (depth > 1 && used[0] == false)
					return;
				
				//사용되지 않았으면 백트래킹. 재귀 진입
				if (!used[i]) {
					used[i] = true;
					chooseM(stats, used, i + 1, depth + 1, N);
					used[i] = false;
				}
			}
		}
	}

	//팀 능력치 계산 메서드
	public static int calStat(int[][] stats, int[] member, int[] people, int start, int depth) {
		int stat = 0;//팀 능력치
		
		//2명 선택됐으면 
		if (depth == 2) {
			stat += stats[people[0]][people[1]];
			stat += stats[people[1]][people[0]];
		}
		//2명 선택되지 않았으면
		else {
			//시작점 start로 이전에 선택여부 따진 것들은 제외.
			for (int i = start; i < member.length; i++) {
				//선택된 멤버 저장
				people[depth] = member[i];
				
				//다음 멤버부터 백트래킹. 백트래킹 후 지금까지 계산된 점수 합치기
				stat += calStat(stats, member, people, i + 1, depth + 1);
			}
		}
		//점수 반환
		return stat;
	}
}
