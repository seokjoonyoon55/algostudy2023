import java.util.Arrays;

public class KMP {
	public static void main(String[] args) {
		pattern = "abacaaba";
		n = pattern.length();	// 8
		table = new int[n];
		
		makeTable();
		
		System.out.println(pattern);
		System.out.println(Arrays.toString(table));
	}
	
	static String pattern;
	static int n;
	static int[] table;
	
	/*
	static void makeTable() {
		
		table[0] = 0;
		
		for (int i=1;i<n;i++) {
			// 부분 문자열 앞에서부터 i인덱스까지
			// 부분 문자열에서 앞뒤로 같은 부분 문자열의 길이 테이블에 저장
			String subPattern = pattern.substring(0, i+1);
			int maxLen = 0;
			
			for (int j=1;j<subPattern.length();j++) {
				String frontTemp = subPattern.substring(0, j);
				String backTemp = subPattern.substring(subPattern.length()-j);

				if (frontTemp.equals(backTemp)) {
					maxLen = j;
				}
				
			}

			table[i] = maxLen;
		}
	}
	*/
	
	static void makeTable() {
		
		table[0] = 0;
		
		for (int i=1;i<n;i++) {
			// 부분 문자열 앞에서부터 i인덱스까지
			// 부분 문자열에서 앞뒤로 같은 부분 문자열의 길이 테이블에 저장
			String subPattern = pattern.substring(0, i+1);
			int maxLen = 0;
			
			for (int j=1;j<subPattern.length();j++) {
				System.out.println(subPattern);
				for (int k=0;k<j;k++) {
					System.out.println(subPattern.charAt(k) + " " + subPattern.charAt(subPattern.length()-1-k));
					if (subPattern.charAt(k) != subPattern.charAt(subPattern.length()-1-j)) {
						System.out.println("false");
						break;
					}
					System.out.println("true");
					
					if (j > maxLen) maxLen = j;
				}
				
				
				
				
			}

			table[i] = maxLen;
		}
	}
}
