package Java;

import java.util.Scanner;

public class SWEA_0314_DD_1949_µî»ê·ÎÁ¶¼º {

	static int N,K,res,max;
	static int[][] arr,visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][N];
			max = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
					if(arr[i][j]>max) {
						max = arr[i][j];
					}
				}
			}
			res = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]==max) {
						ans = new boolean[N][N];
						ans[i][j]=true;
						dfs(i,j,1,1);
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void dfs(int r,int c,int sum, int change) {
		if(sum>res) res = sum;
		
		for(int i=0;i<4;i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(ans[nx][ny]==true) continue;
		
			if(change==1) {								
				if(arr[nx][ny]>=arr[r][c]+K) continue;
				
				ans[nx][ny]=true;
				int tmp = arr[nx][ny];
				int index=0;
				while(arr[nx][ny]>=arr[r][c]) {
					arr[nx][ny]--;
					index++;
				}
				if(index==0) {				//¾È±ðÀ½
					dfs(nx,ny,sum+1,1);
				}	
				else{ 						//±ðÀ½
					dfs(nx,ny,sum+1,0);
				}
				arr[nx][ny]=tmp;
				ans[nx][ny]=false;
			}
			if(arr[r][c]<=arr[nx][ny]) continue;	
			ans[nx][ny]=true;
			dfs(nx,ny,sum+1,0);
			ans[nx][ny]=false;
		}
	}
}
