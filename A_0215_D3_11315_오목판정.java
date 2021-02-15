package Java;

import java.util.Scanner;

public class A_0215_D3_11315_오목판정 {
	
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(sc.next());
			char[][] arr = new char[N][N];
			String result = "NO";
			
			for(int i=0;i<N;i++) {
				String s = sc.next();
				for(int j=0;j<N;j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='o') {
						for(int k=0;k<8;k++) {
							for(int m=1;m<5;m++) {
								int nx = i + dx[k] * m;
								int ny = j + dy[k] * m;
								
								if(nx<0 || nx>=N || ny<0 || ny>=N)
									break;
								
								if(arr[nx][ny]!='o')
									break;
								
								if(m==4)
									result = "YES";
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
