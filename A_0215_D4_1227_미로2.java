package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_0215_D4_1227_¹Ì·Î2 {
	
	static Queue<int []> queue = new LinkedList<>();
	static int[][] miro;
	static boolean[][] visit;
	static int N = 100, result;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int tc = Integer.parseInt(sc.next());
			result = 0;
			miro = new int[N][N];
			visit = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				String s = sc.next();
				for(int j=0;j<N;j++) {
					miro[i][j] = s.charAt(j)-'0';
				}
			}
			
			bfs(1,1);
			
			System.out.println("#"+t+" "+result);
			
		}
	}
	private static void bfs(int r,int c) {
		queue.offer(new int[] {r,c});
		visit[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[0];
			int y = a[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>99 || ny<0 || ny>99)
					continue;
				
				if(miro[nx][ny]==3) {
					result=1;
					break;
				}
				
				if(miro[nx][ny]==0 && visit[nx][ny]==false) {
					queue.offer(new int[] {nx,ny});
					visit[nx][ny]=true;
				}
			}
		}
	}		
}
