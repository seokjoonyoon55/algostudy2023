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

		boolean texist = true;// 타겟문서 존재여부
		int printCnt=0;//뽑은 문서 수
		int max=0;//중요도 최대값
		
		String[] Ntarget = new String[2]; //N이랑 target 2가지만 들어오므로 크기 2로 한정함
		int N = 0;// 문서 갯수
		int target = 0;// 목표문서 초기위치
		
		int temp = 0;// 큐 저장시 쓰는 임시변수
		int pos = -1;// 목표문서 현재위치


		StringTokenizer stoken;

		Queue<Integer> quu = new LinkedList<>();//문서 나열된 큐
		
		int[] cntArr=new int[10];//중요도1~9 카운트 배열. 넣을때 -1씩 따지는거 귀찮아서 10으로 만들어버림

		for (int tcCnt = 0; tcCnt < TC; tcCnt++) {
			//테스트케이스 마다 초기화
			texist=true;
			printCnt=0;
			max =0;
			
			//문서갯수 N과 목표문서 target 저장
			Ntarget = bfr.readLine().split(" ");
			N = Integer.parseInt(Ntarget[0]);
			target = Integer.parseInt(Ntarget[1]);
			pos = target;//목표문서의 현재위치 저장
			
			stoken = new StringTokenizer(bfr.readLine());

			//문서 중요도를 큐에 쭉 저장
			for (int i = 0; i < N; i++) {
				temp = Integer.parseInt(stoken.nextToken());
				quu.add(temp);//큐에 넣기
				cntArr[temp]++;//중요도 카운트 배열
				if(max<temp) max=temp;//이때 최대값도 저장한다.
			}

			//목표문서가 큐에 아직 존재하면 반복
			while (texist) {
				//최대 중요도보다 작으면 뒤로 옮기기
				if(quu.peek()<max) {
					quu.add(quu.poll());//뒤로 옮기기
					pos=moveTarget(pos,quu.size());//pos 위치 새로고침하는 메서드
				}
				//최대 중요도와 같으면
				else {
					printCnt++;//일단 뽑으니까 뽑은수++
					
					//맨 앞이 목표문서면
					if(pos==0) {
						texist=false;//반복문 종료를 위한 false
					}
					
					//맨 앞이 목표문서가 아니면
					else {
						quu.poll();//큐에서 빼내고
						pos=moveTarget(pos,quu.size());//타겟문서 위치 조정하고
					}
					
					cntArr[max]--;//최대중요도 카운트 갯수 --
					if(cntArr[max]==0)
						while(cntArr[max]==0 && max!=0) max--;//카운트 변수에서 0이 아닌 칸을 만날 때까지 max빼기. 전체가 다 비어있다면 max 최종값은 0
				}
			}
			
			quu.clear();//큐 비우기
			
			//목표문서가 뽑히자마자 반복문 종료되면, 그 시점의 카운트 배열은 max아래로 남아있을 가능성이 있기 때문에
			//0이 아닌 가장 오른쪽칸인 max부터 0까지 카운트배열을 지움. 이때 cntArr[0]은 반드시 0이므로 신경쓰지 않는다. 중요도가 1-9 범위이기 때문.
			for(int i=max;i>0;i--)
				cntArr[i]=0;
			
			System.out.println(printCnt);

		}

	}
	
	//pos--해서 앞으로 옮기되, -1 돼서 뒤로 가면 (큐 사이즈 -1) 로 리턴
	public static int moveTarget(int pos, int size) {
		pos--;
		if(pos<0)
			pos=size-1;
		return pos;
	}
	
}
