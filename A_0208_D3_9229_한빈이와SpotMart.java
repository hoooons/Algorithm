package Java;

import java.util.Scanner;

//조합
public class A_0208_D3_9229_한빈이와SpotMart {

	static int N, M;
	static int max = 0, sum = 0, pick = 2;
	static int[] arr;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			num = new int[N];
			arr = new int[pick];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			com(0, 0);
			System.out.println("#" + t + " " + max);
			max = 0;
		}
	}
	private static void com(int cnt, int start) {
		if (cnt == pick) {
			sum = 0;
			for (int i = 0; i < pick; i++) {
				sum += arr[i];
			}
			if (sum <= M && max < sum)
				max = sum;
			else if (sum > M && max == 0)
				max = -1;
			return;
		}
		for (int i = start; i < N; i++) {
			arr[cnt] = num[i];
			com(cnt + 1, i + 1);
		}
	}
}
	