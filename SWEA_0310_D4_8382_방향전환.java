package Java;

import java.util.Scanner;

public class SWEA_0310_D4_8382_방향전환 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int a = Math.abs(X-x);
			int b = Math.abs(Y-y);
			int c = Math.abs(a-b);
			if(c%2==1) c-=1;
			System.out.println("#"+t+" "+(a+b+c));
		}
	}
}
