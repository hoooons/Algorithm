package Java;

import java.util.Scanner;

public class SWEA_0419_D3_5607_а╤гу {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long[] arr = new long[N+1];
			long res = 0;
			int p = 1234567891;
			arr[0] = 1;
			for(int i=1;i<N+1;i++) 
				arr[i] = arr[i-1] * i % p;
			
			res = ( arr[N] * power(arr[R],p-2,p)
					% p * power(arr[N-R],p-2,p)
					% p ) % p;
			System.out.println("#"+t+" "+res);
		}
	}
	private static long power(long x,long y,long p) {
		long tmp = 1;
		x = x % p;
		while(y>0) {
			if(y%2==1)
				tmp = (tmp*x)%p;
			y = y >> 1;
			x = (x*x) % p;
		}
		return tmp;
	}
}
