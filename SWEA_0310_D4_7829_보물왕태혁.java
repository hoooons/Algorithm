package Java;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_0310_D4_7829_º¸¹°¿ÕÅÂÇõ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int res = 0;
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			if(N==1) res=arr[0]*arr[0];
			else{			
				res=arr[0]*arr[N-1];
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
