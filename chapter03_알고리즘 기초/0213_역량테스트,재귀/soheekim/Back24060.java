package study0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//시간초과
public class Back24060 {
	public static int cnt = 0;
	public static int target = 0;
	public static int stopif1=0;

	public static void main(String[] args) throws IOException {
		//입력받기
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = bfr.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		target = Integer.parseInt(NK[1]);

		//쪼개서 배열에 넣기
		String[] numString = bfr.readLine().split(" ");
		int[] numArr = new int[N];

		for (int i = 0; i < N; i++)
			numArr[i] = Integer.parseInt(numString[i]);

		//병합정렬
		merge_sort(numArr, 0, N - 1);
		
		//끝까지 했는데 중간에 멈출일 없으면 -1 출력
		if(stopif1==0)
			System.out.println(-1);
		bfr.close();
	}

	//멈춤신호 있으면 수행 안하고 넘어감
	public static void merge_sort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			if(stopif1==1) return;
			else merge_sort(A, p, q);
			if(stopif1==1) return;
			else merge_sort(A, q + 1, r);
			if(stopif1==1) return;
			else merge(A, p, q, r);
		}
	}

	//타겟 있으면 그순간 출력하고 함수 종료
	public static void merge(int[] arr, int p, int q, int r) {
		int[] temp = new int[arr.length];
		int i = p;
		int j = q + 1;
		int t = 0;
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				cnt++;
				if (cnt == target) {
					System.out.println(arr[i]);
					stopif1=1;
					return;
				}
				temp[t++] = arr[i++];
			} else {
				cnt++;
				if (cnt == target) {
					System.out.println(arr[j]);
					stopif1=1;
					return;
				}
				temp[t++] = arr[j++];
			}
		}
		while (i <= q) {
			cnt++;
			if (cnt == target) {
				System.out.println(arr[i]);
				stopif1=1;
				return;
			}
			temp[t++] = arr[i++];
		}

		while (j <= r) {
			cnt++;
			if (cnt == target) {
				System.out.println(arr[j]);
				stopif1=1;
				return;
			}
			temp[t++] = arr[j++];
		}

		i = p;
		t = 0;
		while (i <= r)
			arr[i++] = temp[t++];
	}

}
