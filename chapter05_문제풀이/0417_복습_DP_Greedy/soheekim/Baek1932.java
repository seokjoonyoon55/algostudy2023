package study0417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Baek1932 {
	static int N;// 줄 갯수
	static int[][] val, res;// 삼각형 저장

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bfr.readLine());// 줄 갯수
		val = new int[N + 1][];// 삼각형 저장
		res = new int[N + 1][];// 계산값 저장
		int max = Integer.MIN_VALUE;

		String[] tempS;// 입력받기용 임시변수

		// N개 라인에 할당 및 입력
		for (int line = 1; line <= N; line++) {
			val[line] = new int[line];// 할당
			res[line] = new int[line];// 할당

			tempS = bfr.readLine().split(" ");// 입력받기

			// 받은 String > Int 변환 후 입력
			for (int i = 0; i < line; i++) {
				val[line][i] = Integer.parseInt(tempS[i]);
			}
		}

		// test
//		print(val);

		// dp 계산용 변수
		int left, right, routeL, routeR;

		// 초기값 설정
		res[1][0] = val[1][0];
        max=res[1][0];
        
		// 2번째 라인부터, 왼루트 오른루트 최대값 + 자기자신값 계산해서 채워넣기
		for (int line = 2; line <= N; line++) {
			for (int idx = 0; idx < val[line].length; idx++) {
				// System.out.println(line+" "+idx);
				left = idx - 1;// 왼루트 인덱스
				right = idx;// 오른루트 인덱스

				// 인덱스 경계조건
				routeL = left < 0 ? 0 : res[line - 1][left];
				routeR = right >= line - 1 ? 0 : res[line - 1][right];

				// 왼루트 오른루트 최대값 + 자기자신값 계산
				res[line][idx] = Math.max(routeL, routeR) + val[line][idx];

				// 마지막 줄이라면 최대값 갱신
				if (line == N && max < res[line][idx])
					max = res[line][idx];
			}
		}

//		System.out.println();
//		print(res);

		//출력
		System.out.println(max);

	}

	// 테스트용 출력 메서드
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
