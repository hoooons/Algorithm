package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// �ڽ��� ������ �˷��� 
// ��� ��尡 �ڽź��� ũ�ų�, ū�ֵ����� �� ũ��, �۰ų�, �����͵鿡�� �� �۾ƾ���
public class SWEA_0421_D4_5643_Ű���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N+1][N+1];
			
			for(int i=0;i<M;i++) 
				arr[sc.nextInt()][sc.nextInt()] = 1;

			int res = 0;
			Queue<int[]> queue = new LinkedList<>();	// Ž���� ���� ť
			for(int i=1;i<=N;i++) {
				boolean[] ans = new boolean[N+1];		// �湮ó���� ���� boolean �迭
				for(int j=1;j<=N;j++) {
					if(i==j) {
						queue.add(new int[] {j,-1});	// ���������� ã�ƾ��Ѵٸ� -1
						ans[j] = true;
					}
					if(arr[i][j]==1) {
						queue.add(new int[] {j,1});		// ū������ ã�ƾ��Ѵٸ� +1
						ans[j] = true;
					}
				}
				while(!queue.isEmpty()) {				// bfs Ž��
					int[] a = queue.poll();
					int tmp = a[0];
					int dif = a[1];
					
					for(int j=1;j<=N;j++) {
						if(ans[j]==true) continue;
						if(arr[j][tmp]==1 && dif==-1) {
							queue.add(new int[] {j,-1});
							ans[j] = true;
						}
						if(arr[tmp][j]==1 && dif==1) {
							queue.add(new int[] {j,1});
							ans[j] = true;
						}
					}
				}
				for(int j=1;j<=N;j++) {					// ��� �湮���ߴٸ� => ���� �� �� ����.
					if(ans[j]==false) break;
					if(j==N) res++;
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
