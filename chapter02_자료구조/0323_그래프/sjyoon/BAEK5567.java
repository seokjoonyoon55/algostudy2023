import java.util.Scanner;
import java.util.Stack;

public class BAEK5567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 초대할 친구 학번 넣을 스택
		Stack<Integer> st = new Stack<>();
		// 친구 관계 정보 저장할 2차원 배열
		boolean[][] arr = new boolean[n+1][n+1];
		
		// 배열에서 친구관계 true로 저장
 		for (int t=0;t<m;t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = true;
		}
		
		// 상근이(학번 1)의 친구 스택에 저장
		for (int i=2;i<=n;i++) {
			if (arr[1][i]) {
				st.add(i);
			}
		}
		
		// 이거 안하고 밑에 for문의 조건에 그냥 st.size() 넣으면
		// for문을 돌면서 스택의 size가 바뀌므로 조건이 바뀜
		// 따라서 고정적으로 값을 주기 위해서 임시 변수에 저장
		int temp = st.size();
		
		// 상근이의 친구의 친구를 스택에 저장
		// 스택에서 값을 조회해서 그 친구 번호의 행을 조회
		// 위에서 2차원 배열의 반쪽만 값을 저장했으므로 열의 초기값은 행 번호
		// 그리고 이미 스택에 있는 친구는 거르기 위해 조건에 추가함
		for (int i=0;i<temp;i++) {
			for (int j=st.get(i);j<=n;j++) {
				if (arr[st.get(i)][j] && !st.contains(j)) {
					st.add(j);
				}
			}
		}
		
		System.out.println(st.size());
		
		sc.close();
	}
}
