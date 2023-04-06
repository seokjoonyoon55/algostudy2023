import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BAEK_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr= new int[N][3];	// 회의 정보 저장할 배열
		int max = 0;				// 가장 뒷타임의 종료시간 저장할 변수
		
		for (int n=0;n<N;n++) {
			// 회의 시작 시간과 종료 시간 저장
			arr[n][0] = sc.nextInt();
			int temp = sc.nextInt();
			arr[n][1] = temp;
			
			// 가장 늦은 시간에 진행하는 회의의 종료 시간 구하기
			if (temp > max) {
				max = temp;
			}
			
			// 회의 진행 시간 계산해서 저장
			arr[n][2] = arr[n][1] - arr[n][0];
		}
		
		// 회의 진행시간을 기준으로 배열 정렬
		// 진행시간이 같다면 시작 시간 순으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					return o1[0] - o2[0];
				}
				else return o1[2] - o2[2];
			}
		});
		
		// 회의실 사용중인지 체크하기 위한 배열
		boolean[] using = new boolean[max];
		// 회의의 최대 개수 저장할 변수
		int cnt = 0;
		
		Loop:
		for (int i=0;i<N;i++) {
			// 시작시간과 종료시간이 같은 회의는 
			// 사용하지 않고 카운트 올리기
			if (arr[i][2] == 0) {
				cnt++;
				continue;
			}
			
			// 회의 시작 시간과 끝나는 시간 사이에 이미 회의가 존재하면
			// 다음 행으로 넘어감
			for (int j=arr[i][0];j<arr[i][1];j++) {
				if (using[j]) continue Loop;
			}
			
			// 아니라면 회의 횟수 카운트 하고
			// 해당 시간에 방문 체크
			cnt++;
			System.out.println(arr[i][0]+ " " + arr[i][1] + " " + arr[i][2]);
			for (int j=arr[i][0];j<arr[i][1];j++) {
				using[j] = true;
			}
		}
		
		System.out.println(cnt);
		sc.close();
		String damn = "몰?루";
	}
}
