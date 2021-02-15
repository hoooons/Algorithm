package Java;

import java.util.Scanner;

public class A_0215_D3_7227_사랑의카운슬러 {

	static int N;
	static long diff;
	static int[][] arr;
	static int[] num;
	static boolean[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][2];
			num = new int[N];
			ans = new boolean[N];
			diff = Long.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			per(0,0);
			System.out.println("#" + t + " " + diff);
		}
	}

	private static void per(int cnt,int flag) {
		if (cnt == N) {
			long x = 0, y = 0;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					x += arr[num[i]][0];
					y += arr[num[i]][1];
				} else if (i % 2 == 1) {
					x -= arr[num[i]][0];
					y -= arr[num[i]][1];
				}
			}
			long tmp = (x * x) + (y * y);

			diff = (diff > tmp) ? tmp : diff;

			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i)!=0)
				continue;

			num[cnt] = i;
			ans[i] = true;
			per(cnt + 1,flag | 1<<i);
			ans[i] = false;
		}
	}
}