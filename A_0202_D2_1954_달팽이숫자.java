package Java;

import java.util.Scanner;

public class A_0202_D2_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int count = 1, r = 0, c = -1, dir = 1, n = N;
			while (true) {
				for (int i = 0; i < n; i++) {
					c += dir;
					arr[r][c] = count++;
				}
				n--;
				if (n == 0)
					break;
				for (int i = 0; i < n; i++) {
					r += dir;
					arr[r][c] = count++;
				}
				dir *= -1;
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
