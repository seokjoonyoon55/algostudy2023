import java.util.Scanner;
import java.util.Stack;

public class BAEK9372 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 크루스칼 알고리즘 이용
			// 선택한 간선이 연결하는 접점을 저장할 리스트(스택) 선언
			Stack<Integer> group = new Stack<>();
			// 입력 받을 간선의 양 끝 접점
			int a;
			int b;
			// 간선의 개수 셀 변수
			int cnt = 0;
			
			// 처음 입력 받는 간선은 바로 선택
			// 비행기 종류의 개수만 세면 되므로 한 간선을 여러번 타도 무방
			// 따라서 시작 위치와 도착 위치는 중요하지 않음
			group.add(sc.nextInt());
			group.add(sc.nextInt());
			cnt++;
			
			// 크루스칼 알고리즘
			for (int m=0;m<M-1;m++) {
				a = sc.nextInt();
				b = sc.nextInt();
				// 간선의 양 접점이 이미 나온(스택에 있는) 점이라면 넘어감
				if (group.contains(a) && group.contains(b)) {
					continue;
				}
				// 
				else if (!group.contains(a) && !group.contains(b)) {
					cnt++;
					continue;
				}
				// 아니라면 스택에 접점 정보 저장하고 cnt 업
				else {
					if (!group.contains(a)) group.add(a);
					if (!group.contains(b)) group.add(b);
					cnt++;
				}
				
			}
			
			System.out.println(cnt);
			
		}
		
		sc.close();
	}
}
