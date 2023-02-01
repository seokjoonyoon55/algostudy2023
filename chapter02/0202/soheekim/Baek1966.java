package study0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(bfr.readLine());

		String[] Ntarget = new String[2];
		int N = 0;// 문서 갯수
		int target = 0;// 타겟문서 초기위치
		int temp = 0;// 큐 트리셋 저장시 쓰는 임시변수
		int pos = -1;// 타겟 문서 현재위치
		boolean texist = true;// 타겟문서 존재여부
		int printCnt=0;//뽑은 문서 수
		int max=0;//중요도 최대값

		StringTokenizer stoken;

		Queue<Integer> quu = new LinkedList<>();
		
		int[] cntArr=new int[10];//중요도1~9 카운트 변수. -1씩 따지는거 귀찮아서 10으로 만들어버림

		for (int tcCnt = 0; tcCnt < TC; tcCnt++) {
			texist=true;
			printCnt=0;
			max =0;
			
			Ntarget = bfr.readLine().split(" ");
			N = Integer.parseInt(Ntarget[0]);
			target = Integer.parseInt(Ntarget[1]);
			pos = target;//현재위치 저장
			
			stoken = new StringTokenizer(bfr.readLine());

			for (int i = 0; i < N; i++) {
				temp = Integer.parseInt(stoken.nextToken());
				quu.add(temp);
				cntArr[temp]++;
				if(max<temp) max=temp;
			}

			while (texist) {
				//최대 우선순위보다 작으면 뒤로 옮기기
				if(quu.peek()<max) {
					quu.add(quu.poll());
					pos=moveTarget(pos,quu.size());
				}
				//최대 우선순위와 같으면
				else {
					//타겟문서가 맨 앞이면
					if(pos==0) {
						printCnt++;
						texist=false;
					}
					//타겟문서가 아니면
					else {
						printCnt++;//뽑은수 ++
						quu.poll();//뽑고
						pos=moveTarget(pos,quu.size());//타겟문서 위치 조정하고
						

					}
					cntArr[max]--;//최대우선순위 카운트 갯수 --
					if(cntArr[max]==0)
						while(cntArr[max]==0 && max!=0) max--;
				}
			}
			
			quu.clear();
			for(int i=max;i>0;i--)
				cntArr[i]=0;
			
			
			System.out.println(printCnt);

		}

	}
	
	//pos를 앞으로 옮기되, -1돼서 뒤로가면 큐 사이즈 -1 로 리턴하는 메서드
	public static int moveTarget(int pos, int size) {
		pos--;
		if(pos<0)
			pos=size-1;
		return pos;
	}
	
}
