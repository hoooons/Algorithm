package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_0208_D3_1206_View {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int count = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) 
				arr[i]=Integer.parseInt(st.nextToken());
			
			for(int i=2;i<N-2;i++) {
				int a = arr[i]-arr[i-2];
				int b = arr[i]-arr[i-1];
				int c = arr[i]-arr[i+1];
				int d = arr[i]-arr[i+2];
				int dif = Math.min(Math.min(a, b),Math.min(c, d));
				if(dif>0) 
					count+=dif;
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
