package Java;

import java.util.Scanner;

public class A_0215_D3_6808_규영이와인영이의카드게임 {

	static int N = 18, pick = 9, win = 0, lose = 0;
	static boolean[] ans;
	static int[] input, arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			input = new int[pick];
			arr = new int[pick];
			ans = new boolean[N];
			for (int i = 0; i < 9; i++) {
				int x = sc.nextInt();
				input[i] = x;
				x--;
				ans[x] = true;
			}
			per(0);
			System.out.println("#"+t+" "+win+" "+lose);
		}
	}
	
	private static void per(int cnt) {
		if(cnt==pick) {
			int a=0,b=0;
			for(int i=0;i<9;i++) {
				if(input[i]>arr[i]) 
					a += input[i]+arr[i];
				else
					b += input[i]+arr[i];
			}			
			if(a>b)	win++;
			else lose++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (ans[i] == true) continue;

			arr[cnt] = i+1;
			ans[i] = true;
			per(cnt + 1);
			ans[i] = false;
		}
	}
}
