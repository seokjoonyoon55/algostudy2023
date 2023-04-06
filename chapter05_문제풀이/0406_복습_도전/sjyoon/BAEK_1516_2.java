import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BAEK_1516_2 {
	static int N;
	static List<Integer>[] arr;
	static int[] value;
	static int[] cond;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		// 건물 짓는 데 걸리는 시간과 선행조건 저장할 배열
		arr = new ArrayList[N+1];
				
		// 시간과 선행조건 저장
		// 시간 계산시 선행조건은 고려하지 않음
		for (int n=1;n<N+1;n++) {
			String[] temp = sc.nextLine().split(" ");
			// 객체 생성
			arr[n] = new ArrayList<>();
			// 건설시간 저장
			arr[n].add(Integer.parseInt(temp[0]));
			// 선행조건 저장
			if (temp[1].equals("-1")) {
				arr[n].add(0);
			}
			else {
				for (int i=1;i<temp.length-1;i++) {
					arr[n].add(Integer.parseInt(temp[i]));
				}
			}
		}
		
		// 선행조건 고려한 최종값 저장할 배열
		value = new int[N+1];
		
		for (int i=1;i<N+1;i++) {
			value[i] = getValue(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(value[1]);
		
		for (int i=2;i<N+1;i++) {
			sb.append("\n"+ value[i]);
		}
		
		System.out.print(sb);
		
	}
	
	static int getValue(int idx) {
		// 선행조건이 없으면 건설시간 바로 반환
		if (arr[idx].get(1) == 0) {
			return arr[idx].get(0);
		}
		
		// 선행조건 있으면 선행조건의 건설시간도 합산
		// 이 때, value 배열에 선행조건의 저장해둔(건설시간이 확정된) 값이 있다면
		// 메소드 호출하지 말고 값 바로 불러와서 사용
		int sum = arr[idx].get(0);
		
		for (int i=1;i<arr[idx].size();i++) {
			if (value[arr[idx].get(i)] != 0) {
				sum += value[arr[idx].get(i)];
			}
			else sum += getValue(arr[idx].get(i));	
		}
		
		return sum;
	}
}
