package Java;

import java.util.Scanner;

public class SWEA_0412_DD_5644_�������� {
	
	static int x1,y1,x2,y2;
	static int M,BC,res;
	static int[][] arr;
	static int[] dx = {0,0,1,0,-1};	// ��,��,��,��
	static int[] dy = {0,-1,0,1,0};
	static int[] A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			M = sc.nextInt();		// �̵��ð�
			BC = sc.nextInt();		// bc�� ����
			
			A = new int[M+1];		// A�� ���
			B = new int[M+1];		// B�� ���
			arr = new int[BC][4];	// BC�� ������ ��� �迭
			
			x1=1; y1=1; 			// A�� ������ǥ
			x2=10; y2=10;			// B�� ������ǥ
			res = 0;				// �����
			
			for(int i=1;i<M+1;i++) 
				A[i] = sc.nextInt();
			for(int i=1;i<M+1;i++) 
				B[i] = sc.nextInt();
			for(int i=0;i<BC;i++) {
				arr[i][0] = sc.nextInt();		// BC x��ǥ
				arr[i][1] = sc.nextInt();		// BC y��ǥ
				arr[i][2] = sc.nextInt();		// BC�� C(�Ÿ�)
				arr[i][3] = sc.nextInt();		// BC�� P(������)
			}
			move();
			System.out.println("#"+t+" "+res);
		}
	}
	private static void move() {
		for(int i=0;i<=M;i++) {					// �̵�
			x1 += dx[A[i]];
			y1 += dy[A[i]];
			x2 += dx[B[i]];
			y2 += dy[B[i]];
			
			int sum = 0;
			for(int a=0;a<BC;a++) {				// A�� ������ BC
				for(int b=0;b<BC;b++) {			// B�� ������ BC
					int tmp = 0;
					int tmpA = Math.abs(arr[a][0]-x1) + Math.abs(arr[a][1]-y1) <= arr[a][2] ? arr[a][3] : 0;
					int tmpB = Math.abs(arr[b][0]-x2) + Math.abs(arr[b][1]-y2) <= arr[b][2] ? arr[b][3] : 0;
					
					if(a!=b) {						// BC�� �ٸ���
						tmp = tmpA + tmpB;			// ���� ����
					}else {							// BC�� ������
						tmp = Math.max(tmpA, tmpB);	// ū�� ����
					}
					if(sum < tmp) sum = tmp;		// ������� �ִ��� �� ã��
				}
			}
			res+=sum;
		}
	}
}





















