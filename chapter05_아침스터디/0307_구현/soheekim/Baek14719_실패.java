package study0308;

import java.util.Scanner;

//틀린 코드
public class Baek14719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();//높이
		int W = sc.nextInt();//너비

		int last = 0;//지난 칸 높이
		int cur = 0;//현재 칸 높이
		int wall = 0;//벽
		int wallLast = 0;//지난 벽
		int cntAdd = 0;//더한 인덱스 수
		int water = 0;//물 양

		//받으면서 계산
		for (int i = 0; i <= W; i++) {
			last = cur;//지난 칸 저장
			
			//마지막이 아니면 입력받기
			if (i != W)
				cur = sc.nextInt();
			//마지막이면 0처리
			else
				cur = 0;
			//이전칸이 더 높거나, 마무리 시점이라면
			if (last > cur || i == W) {
				//지난 벽 저장
				wallLast = wall;
				wall = last;
				//뒷벽 높이가 더 낮으면
				if (wallLast > wall) {
					//그 높이만큼 물 새어나감
					water -= cntAdd * (wallLast - wall);
				}
				//카운트 리셋
				cntAdd = 0;
			}
			//벽 판단이 아니라 고이는 곳이라면
			if (i != W && wall > cur) {
				//차이만큼 물 채우고 카운트++
				water += wall - cur;
				cntAdd++;
			}

		}
		//출력
		System.out.println(water);

		sc.close();
	}
}
