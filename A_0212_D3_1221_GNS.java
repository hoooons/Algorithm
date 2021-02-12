package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_0212_D3_1221_GNS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		String[] str = {"ZRO","ONE","TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			String tc = st.nextToken();
			int  N  =Integer.parseInt(st.nextToken());
			
			String[] arr = new String[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) 
				arr[i] = st.nextToken();
			
			System.out.println("#"+t);
			for(int i=0;i<10;i++) {
				for(int j=0;j<N;j++) {
					if(str[i].equals(arr[j])) {
						System.out.print(arr[j]+" ");
					}
				}
			}
		}	
	}
}