package Java;

import java.util.Scanner;

public class A_0205_D4_1861_정사각형방 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			int f = 0, max = 0, res = 0; // 결과값, 최대값, 연산값
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = arr[i][j];
					res = 1;
					int a = i, b = j; // 아래에서 i,j값 변경시 위의 반복문 영향
					while (true) {
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
							break;
					}
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
}
