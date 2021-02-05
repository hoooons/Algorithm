package Java;

import java.util.Scanner;

public class A_0205_D4_1861_정사각형방 {

	static int f = 0, max = 0, res = 0; // 결과값, 최대값, 연산값
	static int[][] arr;
	static int a, b;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			f = 0;
			max = 0;
			res = 0;
			N = sc.nextInt();
			arr = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = arr[i][j];	//위치의값  임시변수에 저장
					res = 1;				//재귀함수에서 사용했던 변수 초기화
					a = i;
					b = j; 
					move(a, b);

					if (res >= max) {
						if (res > max) {
							max = res;
							f = temp;
						} else if (res == max) {
							f = Math.min(f, temp);
						}
					}
				}
			}
			System.out.println("#" + t + " " + f + " " + max);
		}
	}
	// 재귀 함수 
	static void move(int a, int b) {
		if (a - 1 >= 0 && arr[a][b] + 1 == arr[a - 1][b]) {
			res++;
			a--;
		} else if (a + 1 < N && arr[a][b] + 1 == arr[a + 1][b]) {
			res++;
			a++;
		} else if (b - 1 >= 0 && arr[a][b] + 1 == arr[a][b - 1]) {
			res++;
			b--;
		} else if (b + 1 < N && arr[a][b] + 1 == arr[a][b + 1]) {
			res++;
			b++;
		} else
			return;
		move(a, b);
	}
}
