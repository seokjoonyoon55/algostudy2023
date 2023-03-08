package study0309;

import java.util.Scanner;

//테케3번 틀림
public class Baek14888 {
	static int min = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String[] numsS = sc.nextLine().split(" ");
		String[] operatorS = sc.nextLine().split(" ");
		int[] nums=new int[N];
		int[] operator = new int[4];

		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(numsS[i]);
		}
		
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(operatorS[i]);
		}

		boolean[] usedNum = new boolean[N];

		calc(nums, operator, usedNum, N, 0, 0);

		System.out.println(max);
		System.out.println(min);
		sc.close();
	}

	public static void calc(int[] nums, int[] operator, boolean[] usedNum, int N, int res, int depth) {
		int resOrigin=res;
		
		if (depth == N) {
			if (min > res)
				min = res;
			if (max < res)
				max = res;
			return;
		}

		if (depth == 0) {
			for(int i=0;i<N;i++) {
				usedNum[i]=true;
				res = nums[i];
				calc(nums, operator, usedNum, N, res, depth + 1);
				res=resOrigin;
				usedNum[i]=false;
			}
			

		} else {
			for (int i = 0; i < N; i++) {
				if (!usedNum[i]) {
					for (int j = 0; j < 4; j++) {
						if ((operator[j]) != 0) {
							usedNum[i] = true;
							operator[j]--;

							switch (j) {
							case 0:
								res += nums[i];
								break;
							case 1:
								res -= nums[i];
								break;
							case 2:
								res *= nums[i];
								break;
							case 3:
								res /= nums[i];
								break;
							default:
								break;
							}

							calc(nums, operator, usedNum, N, res, depth + 1);

							res=resOrigin;
							operator[j]++;
							usedNum[i] = false;
						}
					}

				}
			}
		}

	}
}
