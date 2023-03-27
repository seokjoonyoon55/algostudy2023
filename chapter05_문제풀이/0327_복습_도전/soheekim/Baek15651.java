package study0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek15651 {
	static int N;// 최대 수
	static int M;// 뽑을 갯수
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		// N M 입력받기
		String[] NM = bfr.readLine().split(" ");
		N = Integer.parseInt(NM[0]);// 최대 수
		M = Integer.parseInt(NM[1]);// 뽑을 갯수

		// 현재 0개 선택된 상태로 순열 만드는 메서드 시작
		perm(0);

		System.out.println(sb2);
	}

	//현재 selected개 선택상태로 순열 만드는 메서드
	public static void perm(int selected) {
		//M개 선택됐으면
		if (selected >= M) {
			//sb에 선택된 것을 sb2에 저장하고 개행 입력
			sb2.append(sb).append("\n");
			return;
		}

		//M개 선택되지 않았으면
		//N개 숫자에 대해
		for (int i = 0; i < N; i++) {
			//i+1 선택
			sb.append(i + 1).append(" ");
			
			//선택수+1 상태로 조합 돌림
			perm(selected + 1);
			
			//선택한 i+1되돌림
			sb.setLength(sb.length() - 2);
		}
	}
}
