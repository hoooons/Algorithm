package Java;

import java.util.Scanner;

public class SWEA_0301_D3_1240_단순2진암호코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][M];
			StringBuilder sb = new StringBuilder();
			int res = 0;
			int[] code = new int[8];
			for(int i=0;i<N;i++){
				String s = sc.next();
				for(int j=0;j<M;j++) {
					arr[i][j] = s.charAt(j)-'0';
				}
			}
			
			//암호 sb에 저장
			for(int i=N-1;i>=0;i--) {
				for(int j=M-1;j>=0;j--) {
					if(arr[i][j]==1) {
						for(int k=55;k>=0;k--) {
							sb.append(arr[i][j-k]);	
						}
						break;
					}
				}
			}
			int idx = 0;
			int cnt = 0;
			while(idx<8) {
				//암호 한자리씩 str에 저장
				StringBuilder str = new StringBuilder();
				for(int i=cnt;i<cnt+7;i++) {
					str.append(sb.charAt(i));
				}
				//StringBuilder는  equals가 안댐..? String으로 복사
				String ss = str.toString();
				
				if(ss.equals("0001101")) code[idx]=0;
				else if(ss.equals("0011001")) code[idx]=1;
				else if(ss.equals("0010011")) code[idx]=2;
				else if(ss.equals("0111101")) code[idx]=3;
				else if(ss.equals("0100011")) code[idx]=4;
				else if(ss.equals("0110001")) code[idx]=5;
				else if(ss.equals("0101111")) code[idx]=6;
				else if(ss.equals("0111011")) code[idx]=7;
				else if(ss.equals("0110111")) code[idx]=8;
				else if(ss.equals("0001011")) code[idx]=9;
				
				idx++;
				cnt+=7;
			}
			int sum = 0;
			int tmp = 0;
			for(int i=0;i<8;i++) {
				sum+=code[i];
				if((i+1)%2==1) {
					tmp+=(code[i]*3);
				}
				else 
					tmp+=code[i];
			}
			if(tmp%10==0)	
				res = sum;
			else
				res = 0;
			
			System.out.println("#"+t+" "+res);
		}
		
	}
}
