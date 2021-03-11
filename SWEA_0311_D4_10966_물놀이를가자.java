package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_0311_D4_10966_물놀이를가자 {

	static int N, M;
	static char[][] arr;
	static int[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.next());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(sc.next());
			M = Integer.parseInt(sc.next());
			arr = new char[N][M];
			visit = new int[N][M];

			Queue<int[]> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < M; j++) {
					if (s.charAt(j) == 'W') {
						queue.offer(new int[] {i,j});
						visit[i][j]=1;
					} 
				}
			}
			int rr,cc,nr,nc;
			while(!queue.isEmpty()) {
				int[] a = queue.poll();
				rr = a[0];
				cc = a[1];
				for(int i=0;i<4;i++) {
					nr = rr + dx[i];
					nc = cc + dy[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc]!=0)
						continue;
					queue.offer(new int[] {nr,nc});
					visit[nr][nc] = visit[rr][cc] + 1;
				}
			}
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					res += visit[i][j];
				}
			}
			res = res-(N*M);
			System.out.println("#" + t + " " + (res));
		}
	}
}
