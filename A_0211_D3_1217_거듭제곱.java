package Java;

import java.util.Scanner;

public class A_0211_D3_1217_°ÅµìÁ¦°ö {
	static int res = 1;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int tc = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();

			System.out.println("#"+t+" "+re(N,M));
			res=1;
		}
	}
	static int re(int r,int c) {
		if(c==0) return 1;
		return r*re(r,c-1);
	}
}
