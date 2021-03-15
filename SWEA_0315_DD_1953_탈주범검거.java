package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_0315_DD_1953_Å»ÁÖ¹ü°Ë°Å {
	
	static int N,M,R,C,L;
	static int[][] arr;
	static boolean[][] ans;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();	// ¹è¿­
			M = sc.nextInt();
			R = sc.nextInt();	// ¸ÇÈ¦
			C = sc.nextInt();	
			L = sc.nextInt();	// ½Ã°£
			
			arr = new int[N][M];
			ans = new boolean[N][M];
			
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					arr[i][j] = sc.nextInt();

			int res = 0;
			bfs(R,C,1);
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(ans[i][j]==true) res++;
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	
	// bfs·Î Å½»ö
	private static void bfs(int r,int c,int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c,cnt});
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int rr = tmp[0];
			int cc = tmp[1];
			int idx = tmp[2];
			ans[rr][cc]=true;
			
			if(idx==L) continue;
			
			int nr = 0;
			int nc = 0;
			
			if(arr[rr][cc]==1) {
				for(int i=0;i<4;i++) {
					nr = rr + dr[i];
					nc = cc + dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==0 || ans[nr][nc]==true) continue;
					if(i==0 && (arr[nr][nc]==3 || arr[nr][nc]==5 || arr[nr][nc]==6)) continue;
					if(i==1 && (arr[nr][nc]==3 || arr[nr][nc]==4 || arr[nr][nc]==7)) continue;
					if(i==2 && (arr[nr][nc]==2 || arr[nr][nc]==4 || arr[nr][nc]==5)) continue;
					if(i==3 && (arr[nr][nc]==2 || arr[nr][nc]==6 || arr[nr][nc]==7)) continue;
					queue.offer(new int[] {nr,nc,idx+1});
				}
			}
			else if(arr[rr][cc]==2) {
				for(int i=0;i<2;i++) {
					nr = rr + dr[i];
					nc = cc + dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==0 || ans[nr][nc]==true) continue;
					if(i==0 && (arr[nr][nc]==3 || arr[nr][nc]==5 || arr[nr][nc]==6)) continue;
					if(i==1 && (arr[nr][nc]==3 || arr[nr][nc]==4 || arr[nr][nc]==7)) continue;
					queue.offer(new int[] {nr,nc,idx+1});
				}
			}
			else if(arr[rr][cc]==3) {
				for(int i=2;i<4;i++) {
					nr = rr + dr[i];
					nc = cc + dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==0 || ans[nr][nc]==true) continue;
					if(i==2 && (arr[nr][nc]==2 || arr[nr][nc]==4 || arr[nr][nc]==5)) continue;
					if(i==3 && (arr[nr][nc]==2 || arr[nr][nc]==6 || arr[nr][nc]==7)) continue;
					queue.offer(new int[] {nr,nc,idx+1});
				}
			}
			else if(arr[rr][cc]==4) {
				for(int i=0;i<4;i++) {
					if(i==0 || i==3) continue;
					nr = rr + dr[i];
					nc = cc + dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==0 || ans[nr][nc]==true) continue;
					if(i==1 && (arr[nr][nc]==3 || arr[nr][nc]==4 || arr[nr][nc]==7)) continue;
					if(i==2 && (arr[nr][nc]==2 || arr[nr][nc]==4 || arr[nr][nc]==5)) continue;
					queue.offer(new int[] {nr,nc,idx+1});
				}
			}
			else if(arr[rr][cc]==5) {
				for(int i=0;i<4;i++) {
					if(i==1 || i==3) continue;
					nr = rr + dr[i];
					nc = cc + dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==0 || ans[nr][nc]==true) continue;
					if(i==0 && (arr[nr][nc]==3 || arr[nr][nc]==5 || arr[nr][nc]==6)) continue;
					if(i==2 && (arr[nr][nc]==2 || arr[nr][nc]==4 || arr[nr][nc]==5)) continue;
					queue.offer(new int[] {nr,nc,idx+1});
				}
			}
			else if(arr[rr][cc]==6) {
				for(int i=0;i<4;i++) {
					if(i==1 || i==2) continue;
					nr = rr + dr[i];
					nc = cc + dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==0 || ans[nr][nc]==true) continue;
					if(i==0 && (arr[nr][nc]==3 || arr[nr][nc]==5 || arr[nr][nc]==6)) continue;
					if(i==3 && (arr[nr][nc]==2 || arr[nr][nc]==6 || arr[nr][nc]==7)) continue;
					queue.offer(new int[] {nr,nc,idx+1});
				}
			}
			else if(arr[rr][cc]==7) {
				for(int i=0;i<4;i++) {
					if(i==0 || i==2) continue;
					nr = rr + dr[i];
					nc = cc + dc[i];
					if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]==0 || ans[nr][nc]==true) continue;
					if(i==1 && (arr[nr][nc]==3 || arr[nr][nc]==4 || arr[nr][nc]==7)) continue;
					if(i==3 && (arr[nr][nc]==2 || arr[nr][nc]==6 || arr[nr][nc]==7)) continue;
					queue.offer(new int[] {nr,nc,idx+1});
				}
			}
		}
	}
}
