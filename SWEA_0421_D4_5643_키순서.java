package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 자신의 순위를 알려면 
// 모든 노드가 자신보다 크거나, 큰애들한테 또 크고, 작거나, 작은것들에게 또 작아야함
public class SWEA_0421_D4_5643_키순서 {
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
			Queue<int[]> queue = new LinkedList<>();	// 탐색을 위한 큐
			for(int i=1;i<=N;i++) {
				boolean[] ans = new boolean[N+1];		// 방문처리를 위한 boolean 배열
				for(int j=1;j<=N;j++) {
					if(i==j) {
						queue.add(new int[] {j,-1});	// 작은쪽으로 찾아야한다면 -1
						ans[j] = true;
					}
					if(arr[i][j]==1) {
						queue.add(new int[] {j,1});		// 큰쪽으로 찾아야한다면 +1
						ans[j] = true;
					}
				}
				while(!queue.isEmpty()) {				// bfs 탐색
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
				for(int j=1;j<=N;j++) {					// 모든 방문을했다면 => 순위 알 수 있음.
					if(ans[j]==false) break;
					if(j==N) res++;
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
