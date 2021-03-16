package Java;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_0316_DD_4008_숫자만들기 {

	static int N,res,min,max;
	static int[] cal,arr;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			cal = new int[4];
			arr = new int[N];
			
			for(int i=0;i<4;i++)
				cal[i] = sc.nextInt();
			for(int i=0;i<N;i++) 
				arr[i] = sc.nextInt();
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			per(0,arr[0]);
			int res = max-min;
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void per(int cnt,int sum) {
		if(cnt==N-1) {
			if(sum<min) min = sum;
			if(sum>max) max = sum;
			return;
		}
		for(int i=0;i<4;i++) {
			if(cal[i]!=0) {
				if(i==0) {
					int tmp = sum + arr[cnt+1];
					cal[i]--;
					per(cnt+1,tmp);
					cal[i]++;
				}
				else if(i==1) {
					int tmp = sum - arr[cnt+1];
					cal[i]--;
					per(cnt+1,tmp);
					cal[i]++;
				}
				else if(i==2) {
					int tmp = sum * arr[cnt+1];
					cal[i]--;
					per(cnt+1,tmp);
					cal[i]++;
				}
				else if(i==3) {
					int tmp = sum / arr[cnt+1];
					cal[i]--;
					per(cnt+1,tmp);
					cal[i]++;
				}
			}
		}
	}
}
