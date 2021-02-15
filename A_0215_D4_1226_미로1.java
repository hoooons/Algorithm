package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_0215_D4_1226_¹Ì·Î1 {

	static Queue<int[]> queue = new LinkedList<>();
	static int[][] miro;
	static boolean[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(sc.next());
			miro = new int[16][16];
			visit = new boolean[16][16];
			result = 0;
			for (int i = 0; i < 16; i++) {
				String s = sc.next();
				for (int j = 0; j < 16; j++) {
					miro[i][j] = s.charAt(j)-'0';
				}
			}

			bfs(1, 1);
			System.out.println("#" + t + " " + result);

		}
	}

	private static void bfs(int r, int c) {
		queue.offer(new int[] { r, c });
		visit[r][c]=true;
		
		while (!queue.isEmpty()) {
			int arr[] = queue.poll();
			r = arr[0];
			c = arr[1];

			for (int i = 0; i < 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];

				if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16)
					continue;

				if(miro[nx][ny]==3) {
					result = 1;
					break;
				}
				
				if (miro[nx][ny] == 0 && visit[nx][ny]==false) {
					visit[nx][ny]=true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
	}

}
