package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_0301_D4_1211_Ladder2 {
	
	static int res,sum;
	static int[][] arr;
	static boolean[][] ans;
	static int[] dx = {0,0,1};		// 우 좌 하
	static int[] dy = {1,-1,0};		// 우 좌 하
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int tc = sc.nextInt();
			arr = new int[100][100];
			for(int i=0;i<100;i++)
				for(int j=0;j<100;j++)
					arr[i][j] = sc.nextInt();
			
			res = 0; sum=Integer.MAX_VALUE;
			
			for(int j=0;j<100;j++) {
				if(arr[0][j]==1) {
					ans = new boolean[100][100];
					bfs(0,j);
				}
			}
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void bfs(int r,int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		int temp = 1;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			int rr = tmp[0];
			int cc = tmp[1];
			
			ans[rr][cc] = true;
			
			for(int k=0;k<3;k++) {
				int nr = rr + dx[k];
				int nc = cc + dy[k];
				if(nr<0 || nr>=100 || nc<0 || nc>=100 || arr[nr][nc]==0) continue;
				
				if(nr==99 && arr[nr][nc]==1) {
					temp++;
					if(temp<sum) {
						sum = temp;
						res = c;
					}
					return;
				}
				
				if(arr[nr][nc] == 1 && ans[nr][nc] == false) {
					if(k==0 || k==1) {							// 좌, 우가 길이있다면 아래로 못내려가게
						queue.offer(new int[] {nr,nc});
						temp++;
						break;
					}
					else if(k==2){								// 아래로 가기
						queue.offer(new int[] {nr,nc});
						temp++;
					}
				}
			}
		}
	}
}
