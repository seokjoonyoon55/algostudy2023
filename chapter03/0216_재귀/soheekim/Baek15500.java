package study0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//98퍼 실패
public class Baek15500 {
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(bfr.readLine());

		String[] disk = bfr.readLine().split(" ");
		int[] diskInt = new int[N];

		// 원판 입력받아서 저장
		for (int i = 0; i < N; i++) {
			diskInt[i] = Integer.parseInt(disk[i]);
		}

		findmove(diskInt.length, diskInt.length-1, diskInt, sb);
		sb.insert(0, cnt+"\n");
		System.out.println(sb);
		

	}

	public static void findmove(int target, int currentidx, int[] arr, StringBuffer sb) {
		int current = currentidx;
		int targetidx = find(target, arr);

		if (targetidx != -1) {
			if (targetidx == currentidx&&cnt==0) {
				//시작때 맨 위가 타겟이면
				sb.append("1 3\n"); 
				arr[current] = 0;
				
			} else if (targetidx < currentidx) {
				// 타겟인덱스까지 왼쪽으로 이동하면서 1->2로 옮김 출력
				while (current != targetidx) {
					if (arr[current] != 0) {
						sb.append("1 2\n");
						cnt++;
					}
					current--;
					
				}
				// 타겟 인덱스 도달하면 1->3 출력
				if (current == targetidx) {
					sb.append("1 3\n");
					cnt++;
					// 타겟 인덱스 0 만들기
					arr[current] = 0;
				}
			} else if (targetidx > currentidx) {

				// 타겟 인덱스 도달하면 1->3 출력
				// 타겟 인덱스 0 만들기

				// 타겟인덱스까지 오른쪽으로 이동하면서 2->1로 옮김 출력
				while (current != targetidx) {
					if (arr[current] != 0) {
						sb.append("2 1\n");
						cnt++;
					}
					current++;
				}
				// 타겟 인덱스 도달하면 2->3 출력
				if (current == targetidx) {
					sb.append("2 3\n");
					cnt++;
					// 타겟 인덱스 0 만들기
					arr[current] = 0;
				}
			}
			// 다음 과정 시작
			findmove(target - 1, current, arr, sb);
		}

	}

	public static int find(int target, int[] arr) {
		int targetidx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]!=0&&arr[i] == target)
				targetidx = i;
		}
		return targetidx;
	}
}