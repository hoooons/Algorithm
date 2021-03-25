package Java;

import java.util.Scanner;

public class SWEA_0325_D3_3307_최장증가부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			int[] LIS = new int[N];
			for(int i=0;i<N;i++) 
				num[i] = sc.nextInt();
			
			int max = 0;
			for(int i=0;i<N;i++) {
				LIS[i] = 1;
				for(int j=0;j<i;j++) {
					if(num[j]<=num[i] && LIS[j]+1>LIS[i])
						LIS[i] = LIS[j]+1;
				}
				if(max<LIS[i]) max = LIS[i];
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
