package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_0218_D5_1247_최적경로 {
	
 	static List<int[]> list;
	static List<int[]> home;
	static int N,sum,res;
	static int[] turn;
	static boolean[] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			list = new ArrayList<>();
			home = new ArrayList<>();
			sum = 0;
			res = Integer.MAX_VALUE;
			N =sc.nextInt();
			ans = new boolean[N];
			turn = new int[N];
			
			for(int i=0;i<2;i++)	//집 회사
				home.add(new int[] {sc.nextInt(),sc.nextInt()});
			
			for(int i=0;i<N;i++) 	//고객
				list.add(new int[] {sc.nextInt(),sc.nextInt()});
			
			per(0);
			System.out.println("#"+t+" "+res);
		}
	}
	private static void per(int cnt) {
		if(cnt==N) {
			sum = 0;
			sum += Math.abs(home.get(0)[0]-list.get(turn[0])[0]) + Math.abs(home.get(0)[1]-list.get(turn[0])[1]);
			for(int i=1;i<N;i++) 
				sum += Math.abs(list.get(turn[i-1])[0]-list.get(turn[i])[0]) + Math.abs(list.get(turn[i-1])[1]-list.get(turn[i])[1]);
			sum += Math.abs(home.get(1)[0]-list.get(turn[N-1])[0]) + Math.abs(home.get(1)[1]-list.get(turn[N-1])[1]);
			if(sum<res) res = sum;
			return;
		}
		for(int i=0;i<N;i++) {
			if(ans[i]==true) continue;
			turn[cnt]=i;
			ans[i]=true;
			per(cnt+1);
			ans[i]=false;
		}
	}
}
