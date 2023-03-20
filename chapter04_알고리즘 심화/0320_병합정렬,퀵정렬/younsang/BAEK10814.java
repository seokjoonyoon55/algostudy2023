package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK10814 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// stringbuilder로 된 배열을 만듦
		StringBuilder[] arr = new StringBuilder[202];
		for (int i = 0; i < N; i++) {
			String[] ageName = br.readLine().split(" ");
			// 해당 인덱스가 비어있으면 새로 stringbuilder를 선언하고 사람을 append
			if (arr[Integer.parseInt(ageName[0])] == null) {
				StringBuilder sb = new StringBuilder();
				sb.append(ageName[1]).append(" ");
				arr[Integer.parseInt(ageName[0])] = sb;
			// 비어있지 않으면 해당 stringbuilder에 append
			} else {
				arr[Integer.parseInt(ageName[0])] = arr[Integer.parseInt(ageName[0])].append(ageName[1]).append(" ");
			}
		    
		}
		
		// null이 아닌 인덱스만 출력
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				String[] str = arr[i].toString().split(" ");
				for (int j = 0; j < str.length; j++) {
					System.out.print(i + " ");
					System.out.println(str[j]);
				}
			}
		}
		// counting sort를 사용!!!!!!
	}
}
