package study0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baek2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bfr.readLine());// 숫자 갯수

		Long[] nums = new Long[N];// 수 저장 배열

		// 숫자들 입력받기
		String[] tempS = bfr.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(tempS[i]);
		}

		// 절댓값으로 정렬, 절댓값 같은 경우 음수를 앞으로 양수를 뒤로
		Arrays.sort(nums, new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				if (Math.abs(o1) > Math.abs(o2))
					return 1;
				else if (Math.abs(o1) < Math.abs(o2))
					return -1;
				else
					return o1 < o2 ? 1 : -1;
			}

		});

		// System.out.println(Arrays.toString(nums));

		int left = 0;
		int right = 0;
		long minabs = Long.MAX_VALUE;// 최소 절댓값
		long numA = nums[left];// 최소 절댓값일 때 숫자A
		long numB = nums[right];// 최소 절댓값일 때 숫자B

		boolean findSame = false;// 0번 인덱스와 같은 부호 숫자 찾음 여부
		boolean findDiff = false;// 0번 인덱스와 다른 부호 숫자 찾음 여부

		// 0번 인덱스값과, 1번부터 N-1번 인덱스값 합 절댓값 비교
		for (right = 1; right < N; right++) {
			// 같은 부호 수 찾은적 없고 && 같은 부호 수 발견했으면
			if (!findSame && ((nums[left] > 0 && nums[right] > 0) || (nums[left] < 0 && nums[right] < 0))) {
				// 합의 절댓값 계산
				long abs = Math.abs(nums[left] + nums[right]);
				// System.out.println(nums[left] + " " + nums[right] + " " + abs);

				// 최소 절댓값 갱신
				if (minabs > abs) {
					numB = nums[right];
					minabs = abs;

				}

				// 같은 부호수 찾았음 표시
				findSame = true;
			}
			// 다른 부호 수 찾은적 없고 && 다른 부호 수 발견했으면
			else if (!findDiff && ((nums[left] > 0 && nums[right] < 0) || (nums[left] < 0 && nums[right] > 0))) {
				// 합의 절댓값 계산
				long abs = Math.abs(nums[left] + nums[right]);
				// System.out.println(nums[left] + " " + nums[right] + " " + abs);

				// 최소 절댓값 갱신
				if (minabs > abs) {
					numB = nums[right];
					minabs = abs;
				}

				// 다른 부호수 찾았음 표시
				findDiff = true;
			}
			// 같은 부호 수, 다른 부호 수 찾았으면 반복 종료
			if (findSame && findDiff)
				break;
		}

		// 연속된 인덱스값의 부호가 반대인 인덱스쌍 찾기. 0-1 인덱스쌍은 위에서 제일 처음 계산했으므로 제외
		for (int i = 1; i < N - 1; i++) {
			// 연속된 인덱스값의 부호가 반대라면
			if ((nums[i] > 0 && nums[i + 1] < 0) || (nums[i] < 0 && nums[i + 1] > 0)) {
				// 합의 절댓값 계산
				long abs = Math.abs(nums[i] + nums[i + 1]);
				// System.out.println(nums[i] + " " + nums[i + 1] + " " + abs);

				// 최소 절댓값 갱신
				if (minabs > abs) {
					numA = nums[i];
					numB = nums[i + 1];
					minabs = abs;
				}
			}
		}

		// 출력
		if (numA < numB)
			System.out.println(numA + " " + numB);
		else
			System.out.println(numB + " " + numA);

	}
}
