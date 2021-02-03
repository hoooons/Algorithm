package Java;

import java.util.Scanner;

public class A_0203_D2_2001_ÆÄ¸®ÅðÄ¡ {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int T = sc.nextInt();
		 
		 for(int t=0;t<T;t++) {
			 int N = sc.nextInt();
			 int M = sc.nextInt();
			 int [][]arr = new int[N][N];
			 
			 for(int i=0;i<N;i++) {
				 for(int j=0;j<N;j++) {
					 arr[i][j] = sc.nextInt();
				 }
			 }
			 int sum = 0, max = 0;
			 for(int i=0;i<=N-M;i++) {
				 for(int j=0;j<=N-M;j++) {
					 for(int r=i;r<M+i;r++) {
						 for(int c=j;c<M+j;c++) {
							 sum+=arr[r][c];
						 }
					 }
					 if(max<sum) max = sum;
					 sum=0;
				 }
			 }
			 System.out.println("#"+t+" "+max);
		 }
	}
}
