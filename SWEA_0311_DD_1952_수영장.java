package Java;

import java.util.Scanner;

public class SWEA_0311_DD_1952_¼ö¿µÀå {
	
	static int a,b,c,res;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			res = sc.nextInt();
			
			arr = new int[12];
			for(int i=0;i<12;i++) 
				arr[i] = sc.nextInt();
			
			bfs(0,0);
			System.out.println("#"+t+" "+res);
		}
	}
	private static void bfs(int month, int price) {
		if(month>=12) {
			if(price<res) res = price;
			return;
		}
		if(arr[month]==0) 
			bfs(month+1,price);
		
		else {
			int tmp = arr[month] * a;
			bfs(month+1,price+tmp);
			bfs(month+1,price+b);
			bfs(month+3,price+c);
		}
	}
}
