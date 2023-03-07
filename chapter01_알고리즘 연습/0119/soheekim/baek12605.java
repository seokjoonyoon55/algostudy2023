package study0119;

import java.util.Scanner;

public class baek12605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		String[] tc=new String[N];//테스트 케이스 갯수 받아서 String 배열 만들기
		sc.nextLine();// 라인 하나 넘기기
		
		for(int r=0;r<N;r++) {
			tc[r]=sc.nextLine();
		}//테스트 케이스 입력받기
		
		for(int i=0;i<N;i++) {
			System.out.printf("Case #%d: ", i+1);
			String[] splited=tc[i].split(" ");//공백으로 쪼개기
			String[] newsplited = new String[splited.length];//재정렬 후 저장할 String배열 선언

			for(int j=0;j<splited.length;j++) {
				System.out.print(splited[splited.length-1-j]);//거꾸로 출력하기
				if(j!=newsplited.length-1) System.out.print(" ");//마지막 단어 아니면 공백 출력
				else {
					if(i!=N-1) System.out.println();//마지막 단어이지만 마지막 줄이 아니면 개행문자
				}
			}
		}
		sc.close();
	}
}
//3
//this is a test
//foobar
//all your base