import java.util.Scanner;

public class SWEA_0307_D4_1486_장훈이의높은선반 {

	static int[] arr;
	static int res = 0;
	static int N, B;
	static boolean[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();

			arr = new int[N];
			ans = new boolean[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			res = Integer.MAX_VALUE;
			sub(0);

			System.out.println("#"+t+" "+res);
		}
	}

	private static void sub(int cnt) {
		if(cnt==N) {
			int tmp=0;
			
			for(int i=0;i<N;i++) {
				if(ans[i]==true) {
					tmp+=arr[i];
				}
			}
			if(tmp>=B) {
				if(tmp-B<res) {
					res = tmp-B;
				}
			}
			return;
		}
		ans[cnt] = true;
		sub(cnt + 1);
		ans[cnt] = false;
		sub(cnt + 1);
	}
}
