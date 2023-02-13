package chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BAEK14501 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		ArrayList<ArrayList()> arraySet = new ArrayList<>();
		ArrayList<Integer> arrayDay = new ArrayList<>();
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			
			arrayDay.add(T); arrayDay.add(P);
			arraySet.addAll(arrayDay);
				
		}
		
		System.out.println(arraySet);
		
//		int idx = 0;
//		
//		while (idx<arraySet.size()-2) {
//			
//			for (int i=2;i<arraySet.get(idx)+1;i++) {
//				arraySet.remove(idx+i);
//				arraySet.remove(idx+i);
//			}
//			
//			idx+=2;
//		}
		
		System.out.println(arraySet);
	}
}
