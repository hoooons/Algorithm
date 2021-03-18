package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_0318_D4_1249_º¸±Þ·Î {
	
	static int N,res;
	static int[][] arr;
	static int[][] visit;
	static boolean[][] ans;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.next());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(sc.next());
			arr = new int[N][N];
			visit = new int[N][N];
			ans = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				String s = sc.next();
				for(int j=0;j<N;j++) {
					arr[i][j] = s.charAt(j)-'0';
				}
			}
			res = Integer.MAX_VALUE;
			bfs(0,0);
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void bfs(int r,int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		ans[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[0];
			int y = a[1];
			
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(ans[nx][ny]==true) {
					if(visit[nx][ny]>visit[x][y] + arr[nx][ny])
						visit[nx][ny] = visit[x][y] + arr[nx][ny];
					else
						continue;
				}
				else{
					visit[nx][ny] = visit[x][y] + arr[nx][ny];
					ans[nx][ny]=true;
				}
				
				if(nx==N-1 && ny==N-1) {
					res = visit[nx][ny];
				}
				queue.offer(new int[] {nx,ny});
			}
		}
	}
}
