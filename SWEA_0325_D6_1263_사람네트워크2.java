package Java;

import java.util.Scanner;

// Floyd-Washall 알고리즘 (모든 정점 탐색)
public class SWEA_0325_D6_1263_사람네트워크2 {
	
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int val = 999999;
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
					if(i!=j && arr[i][j]==0) {
						arr[i][j] = val;
					}
				}
			}

			for(int k=0;k<N;k++) {				// 경유지
				for(int i=0;i<N;i++) {			// 출발지
					if(i==k) continue;
					for(int j=0;j<N;j++) {		// 도착지
						if(k==j || i==j) continue;
						if(arr[i][k]+arr[k][j] < arr[i][j])
							arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				int tmp = 0;
				for(int j=0;j<N;j++) {
					if(arr[i][j]==val) continue;
					tmp+=arr[i][j];
				}
				if(min>tmp) {
					min = tmp;
				}
			}
			System.out.println("#"+t+" "+min);
		}
	}
}
