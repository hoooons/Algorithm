package Java;

import java.util.Scanner;

public class A_0208_D3_5215_햄버거다이어트 {

	static int N, L, max;
	static boolean[] ans;
	static int[][] arr;
	static int sum = 0, cal = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];
			ans = new boolean[N];

			for (int i = 0; i < N; i++)
				for (int j = 0; j < 2; j++)
					arr[i][j] = sc.nextInt();

			max = 0;
			sub(0);
			System.out.println("#" + t + " " + max);
		}
	}

	private static void sub(int cnt) {

		if (cnt == N) {
			sum = 0;
			cal = 0;
			for (int i = 0; i < N; i++) {
				if (ans[i] == true) {
					sum += arr[i][0];
					cal += arr[i][1];
				}
			}
			if (cal <= L && sum > max)
				max = sum;
			return;
		}
		ans[cnt] = true;
		sub(cnt + 1);
		ans[cnt] = false;
		sub(cnt + 1);
	}
}
