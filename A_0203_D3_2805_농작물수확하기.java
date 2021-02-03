package Java;

import java.util.Scanner;

public class A_0203_D3_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int result = 0;
			for(int i=0;i<N;i++) {
				String str = sc.next();
				for(int j=0;j<N;j++) {
					arr[i][j]=str.charAt(j) - '0';
				}
			}
			if(N==1) {
				result = arr[0][0];
				System.out.println("#"+t+" "+result);
				continue;
			}
			int q = 1, swc = 0;
			int r = N/2;
			int c = 0;
			while(true) {
				for(int i=r;i<q+r;i++) {
					result+=arr[i][c];
				}
				if(c==N)
					break;
				if(swc==0) {
					q+=2;
					r--;
					c++;
				}
				else if(swc==1) {
					q-=2;
					r++;
					c++;
				}
				if(q==N)
					swc = 1;	
			}
			System.out.println("#"+t+" "+result);
		}

	}
}

