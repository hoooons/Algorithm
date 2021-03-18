import java.util.Scanner;

public class SWEA_0318_D4_7465_창용마을무리의개수 {

	static int N,M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N+1];
			
			make();
			
			for(int i=0;i<M;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a,b);
			}
			
			int res = 0;
			for(int i=1;i<N+1;i++) {
				if(i==arr[i])
					res++;
			}
			
			System.out.println("#"+t+" "+res);
		}
		
		
	}
	
	private static void make() {
		for(int i=1;i<=N;i++) {
			arr[i]=i;
		}
	}
	private static int find(int a) {
		if(arr[a]==a)
			return a;
		
		return arr[a] = find(arr[a]);
	}
	private static void union(int a, int b) {
		if(find(a)==find(b))
			return;
		
		arr[find(b)] = find(a);
	}
}
