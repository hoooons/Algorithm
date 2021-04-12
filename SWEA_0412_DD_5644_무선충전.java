package Java;

import java.util.Scanner;

public class SWEA_0412_DD_5644_무선충전 {
	
	static int x1,y1,x2,y2;
	static int M,BC,res;
	static int[][] arr;
	static int[] dx = {0,0,1,0,-1};	// 상,우,하,좌
	static int[] dy = {0,-1,0,1,0};
	static int[] A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			M = sc.nextInt();		// 이동시간
			BC = sc.nextInt();		// bc의 개수
			
			A = new int[M+1];		// A의 경로
			B = new int[M+1];		// B의 경로
			arr = new int[BC][4];	// BC의 정보를 담는 배열
			
			x1=1; y1=1; 			// A의 시작좌표
			x2=10; y2=10;			// B의 시작좌표
			res = 0;				// 결과값
			
			for(int i=1;i<M+1;i++) 
				A[i] = sc.nextInt();
			for(int i=1;i<M+1;i++) 
				B[i] = sc.nextInt();
			for(int i=0;i<BC;i++) {
				arr[i][0] = sc.nextInt();		// BC x좌표
				arr[i][1] = sc.nextInt();		// BC y좌표
				arr[i][2] = sc.nextInt();		// BC의 C(거리)
				arr[i][3] = sc.nextInt();		// BC의 P(충전량)
			}
			move();
			System.out.println("#"+t+" "+res);
		}
	}
	private static void move() {
		for(int i=0;i<=M;i++) {					// 이동
			x1 += dx[A[i]];
			y1 += dy[A[i]];
			x2 += dx[B[i]];
			y2 += dy[B[i]];
			
			int sum = 0;
			for(int a=0;a<BC;a++) {				// A가 선택한 BC
				for(int b=0;b<BC;b++) {			// B가 선택한 BC
					int tmp = 0;
					int tmpA = Math.abs(arr[a][0]-x1) + Math.abs(arr[a][1]-y1) <= arr[a][2] ? arr[a][3] : 0;
					int tmpB = Math.abs(arr[b][0]-x2) + Math.abs(arr[b][1]-y2) <= arr[b][2] ? arr[b][3] : 0;
					
					if(a!=b) {						// BC가 다르면
						tmp = tmpA + tmpB;			// 각각 더함
					}else {							// BC가 같으면
						tmp = Math.max(tmpA, tmpB);	// 큰걸 더함
					}
					if(sum < tmp) sum = tmp;		// 모든경우중 최대의 값 찾기
				}
			}
			res+=sum;
		}
	}
}





















