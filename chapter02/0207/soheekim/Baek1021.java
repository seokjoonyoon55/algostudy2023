package study0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM=bfr.readLine().split(" ");
		int N=Integer.parseInt(NM[0]);
		int M=Integer.parseInt(NM[1]);
		String[] tgstring=bfr.readLine().split(" ");
		int[] tgint = new int[M];
		
		boolean doleft=true;
		
		int deqsize=N;
		int complete=0;
		int cntrl=0;
		
		for(int i=0;i<M;i++) {
			tgint[i]=Integer.parseInt(tgstring[i]);
		}
		
		for(int i=0;i<M;i++) {
			if(tgint[i]<=(deqsize+1)/2) doleft=true;
			else doleft=false;
			
			while(true) {
				if(tgint[i]==1) {
					complete++;
					deqsize--;
					moveleft(tgint,deqsize,complete);
					break;
				}
				else {
					if(doleft) {
						tgint=moveleft(tgint,deqsize,complete);
					}
					else {
						tgint=moveright(tgint,deqsize,complete);
					}
					cntrl++;
				}
			}
		}
		System.out.println(cntrl);
	}
	
	public static int[] moveleft(int[] intarr,int dsize,int compl) {
		int[] temp=intarr;
		for(int i=compl;i<intarr.length;i++) {
			temp[i]--;
			if(temp[i]==0) temp[i]=dsize;
		}
		return temp;
	}
	
	public static int[] moveright(int[] intarr,int dsize,int compl) {
		int[] temp=intarr;
		for(int i=compl;i<intarr.length;i++) {
			temp[i]++;
			if(temp[i]==dsize+1) temp[i]=1;
		}
		return temp;
	}
}
