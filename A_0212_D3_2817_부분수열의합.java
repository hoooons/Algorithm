package Java;

import java.util.Scanner;

public class A_0212_D3_2817_부분수열의합 {

	static int N, K, count;
	static int[] num;
	static boolean[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			num = new int[N];
			ans = new boolean[N];
			count = 0;
			
			for(int i=0;i<N;i++)
				num[i]=sc.nextInt();
			
			sub(0);
			
			System.out.println("#"+t+" "+count);
		}
	}
	static void sub(int cnt) {
		if (cnt == N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(ans[i]==true) 
					sum+=num[i];
			}
			if(sum == K)
				count++;
			
			return;
		}
		ans[cnt] = true;
		sub(cnt + 1);
		ans[cnt] = false;
		sub(cnt + 1);
	}
}
