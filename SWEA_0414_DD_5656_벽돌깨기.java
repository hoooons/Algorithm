package Java;

import java.util.Scanner;

public class SWEA_0414_DD_5656_벽돌깨기 {
	
	static int N,W,H,res;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();		// 횟수
			W = sc.nextInt();		// 세로
			H = sc.nextInt();		// 가로
			
			arr = new int[H][W];	// map설정
			
			for(int i=0;i<H;i++)
				for(int j=0;j<W;j++)
					arr[i][j] = sc.nextInt();
			
			res = Integer.MAX_VALUE;	
			for(int i=0;i<W;i++) {					
				dfs(i,1,arr);		// 처음시작점 
			}
			System.out.println("#"+t+" "+res);
		}
	}
	// 어딜깰지, 몇번짼지, 배열
	private static void dfs(int target,int cnt,int[][] map) {
		if(cnt==N+1) {						// 횟수 채우면 count세서 최소값이면 res로 지정
			int sum = count(map);
			if(sum<res) res = sum;
			return;
		}
		
		int[][] ar = damage(target,map);	// 지정위치 내려가서 깨기
		ar = pull(ar);						// 땡기기
		
		for(int i=0;i<W;i++) {
			dfs(i,cnt+1,ar);				// 다음 횟수로
		}
	}
	// 땡기기
	private static int[][] pull(int[][] map){
		int[][] ar = new int[H][W];
		
		for(int j=0;j<W;j++) {
			int idx = H-1;
			for(int i=H-1;i>=0;i--) {
				if(map[i][j]!=0) {
					ar[idx--][j]=map[i][j];
				}
			}
		}
		return ar;
	}
	// 위에서 뿌시기
	private static int[][] damage(int target,int[][] map){
		int[][] ar = new int[H][W];
		
		for(int i=0;i<H;i++)			//복사하기
			for(int j=0;j<W;j++)
				ar[i][j] = map[i][j];
		
		for(int i=0;i<H;i++) {
			if(ar[i][target]!=0) {
				for(int k=0;k<ar[i][target];k++) {
					for(int d=0;d<4;d++) {
						int nx = i + dx[d] * k;
						int ny = target + dy[d] * k;
						
						if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
						if(ar[nx][ny]==1) ar[nx][ny]=0;
						else if(ar[nx][ny]>1) {
							int p = ar[nx][ny];
							ar[nx][ny]=0;
							ar=hit(nx,ny,ar,p);	
						}
					}
				}
				break;
			}
		}
		return ar;
	}
	// damage받은것중 1이상이면 hit
	private static int[][] hit(int r,int c,int[][] map,int tg){
		int[][] ar = new int[H][W];
		
		for(int i=0;i<H;i++)			//복사하기
			for(int j=0;j<W;j++)
				ar[i][j] = map[i][j];
		
		for(int k=0;k<tg;k++) {
			for(int d=0;d<4;d++) {
				int nx = r+dx[d] * k;
				int ny = c+dy[d] * k;
				
				if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
				if(ar[nx][ny]==1) ar[nx][ny]=0;
				else if(ar[nx][ny]>1) {
					int p = ar[nx][ny];
					ar[nx][ny]=0;
					ar=hit(nx,ny,ar,p);
				}
			}
		}
		return ar;
	}
	// 벽돌세기 
	private static int count(int[][] map) {
		int sum=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(map[i][j]!=0)
					sum++;
			}
		}
		return sum;
	}
}































