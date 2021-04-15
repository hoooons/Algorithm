package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 0 �� 1 ��  2 �� 3 ��
public class SWEA_0415_DD_1953_Ż�ֹ��˰� {

	static int N,M,R,C,L;
	static int[][] map;
	static boolean[][] ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	// �ش� ������ ����ɼ��ִ� ����
	static int[][] d = {{}, {0,1,2,3}, {0,1}, {2,3},{0,3}, {1,3}, {1,2}, {0,2}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();	M = sc.nextInt();
			R = sc.nextInt();	C = sc.nextInt();		
			L = sc.nextInt();						
			map = new int[N][M];
			ans = new boolean[N][M];
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					map[i][j] = sc.nextInt();

				int res = 0;
				bfs(R,C,1);
				
				for(int i=0;i<N;i++) 
					for(int j=0;j<M;j++) 
						if(ans[i][j]==true) res++;
					
				System.out.println("#"+t+" "+res);
		}
	}
	// BFS Ž��
	private static void bfs(int r, int c, int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c,cnt});
		ans[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int idx = tmp[2];
			int dir = map[x][y];		// �ͳ�����
			
			if(idx==L) continue;
			for(int i : d[dir]) {		
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]==0 ||ans[nx][ny]==true) continue;
				
				int p = 0;				// �ش� ��ġ���� ����ɼ��ִ� �� p
				if(i==0) p=1;			// (i�� ���� ����Ű�� p�� �Ʒ��� �����Ѿ� ���ᰡ��)
				else if(i==2) p=3;
				else if(i==3) p=2;
				
				int pdir = map[nx][ny];	// �ش� �ͳο��� p�� �����ϴ��� �Ǻ�
				for(int j : d[pdir]) {	// p�� �����Ѵٸ� ���� ���� 
					if(j==p) {
						queue.offer(new int[] {nx,ny,idx+1});
						ans[nx][ny]=true;
					}
				}
			}
		}
	}
}
