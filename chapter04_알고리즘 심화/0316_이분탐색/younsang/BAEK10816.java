package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BAEK10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 해당 인덱스에 해당하는 value값이 있으면 1 더하기
			if (map.get(num) != null) {
				map.put(num, map.get(num)+1);
			// 해당 인덱스에 해당하는 key 가 없으면 추가
			} else {
				map.put(num, 1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num2 = Integer.parseInt(st.nextToken());
			// 해당 값이 있으면 value값 뽑아서 sb.append
			if (map.get(num2) != null) {
				sb.append(map.get(num2)).append(" ");
			// 해당 값이 없으면 0 append
			} else {
				sb.append(0).append(" ");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}
