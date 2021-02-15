package Java;

import java.util.Scanner;

public class A_0215_DD_4012_¿ä¸®»ç {

	static int N, pick;
	static int[][] arr;
	static int[] food1, food2;
	static boolean[] answer;
	static int diff;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			pick = N / 2;
			diff = Integer.MAX_VALUE;
			arr = new int[N][N];
			answer = new boolean[N];
			food1 = new int[pick];
			food2 = new int[pick];
			
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					arr[i][j] = sc.nextInt();
			
			com(0, 0);
			
			System.out.println("#"+t+" "+diff);
		}
	}
	private static void com(int cnt, int start) {
		if (cnt == pick) {
			int ct = 0, tmp = 0,sum1 = 0,sum2=0;
			for (int i = 0; i < N; i++) {
				if (answer[i] == false) {
					food2[ct++] = i;
				}
			}
			for(int i=0;i<pick;i++) {
				for(int j=0;j<pick;j++) {
					sum1+=arr[food1[i]][food1[j]];
					sum2+=arr[food2[i]][food2[j]];
				}
			}
			tmp = Math.abs(sum1-sum2);
			
			diff = (diff>tmp)?tmp:diff;

			return;
		}
		for (int i = start; i < N; i++) {
			food1[cnt] = i;
			answer[i] = true;
			com(cnt + 1, i + 1);
			answer[i] = false;
		}
	}
}
