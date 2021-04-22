package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_0422_D4_1868_파핑파핑지뢰찾기 {
	
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static int N,res;
	static char[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(sc.next());
			arr = new char[N][N];
			visit = new boolean[N][N];
			res = 0;
			for(int i=0;i<N;i++) {
				String s = sc.next();
				for(int j=0;j<N;j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='.') {
						if(chk(i,j)) {
							bfs(i,j);
							res++;
						}
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='.') {
						res++;
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static boolean chk (int r, int c) {
		for(int i=0;i<8;i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			if(arr[nr][nc] == '*') return false;
		}
		return true;
	}
	private static void bfs(int r, int c) {
		arr[r][c] = '0';
		visit[r][c] = true;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			for(int i=0;i<8;i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];
				if(nr<0 || nr>=N || nc<0 || nc>=N || visit[nr][nc]) continue;
				arr[nr][nc] = '0';
				if(chk(nr,nc)) {
					queue.add(new int[] {nr,nc});
					visit[nr][nc] = true;
				}
			}
		}
	}
}
