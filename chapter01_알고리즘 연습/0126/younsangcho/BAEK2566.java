package algorithm_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BAEK2566 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int[][] arr = new int[9][9];
		
		int max = 0;
		int mi = 0;
		int mj = 0;
		
		for (int i = 0; i < 9; i++) {
			// 공백을 기준으로 token화 해서 입력받게 해주는 방법
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 최댓값보다 큰 경우 최댓값과 좌표 갱신
				if (max <= arr[i][j]) {
					max = arr[i][j];
					mi = i+1;
					mj = j+1;
				
				}
			}
		}
        System.out.println(max);
		System.out.println(mi+" "+mj);
	}
}
