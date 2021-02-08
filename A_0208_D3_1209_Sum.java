package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A_0208_D3_1209_Sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int N = 100;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
//			int tc = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
//					arr[i][j] = sc.nextInt();
				}				
			}
			
			int max = -1;
			int sum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sum+=arr[i][j];
				}
				if(max<sum) max = sum;
				sum=0;
			}
			for(int j=0;j<N;j++) {
				for(int i=0;i<N;i++) {
					sum+=arr[i][j];
				}
				if(max<sum) max = sum;
				sum=0;
			}
			for(int i=0;i<N;i++) {
				sum = arr[i][i];
			}
			if(max < sum) max = sum;
			sum = 0;
			
			int i = 99, j = 0;
			while(i>=0) {
				sum+=arr[i][j];
				i--;
				j++;
			}
			if(max<sum) max = sum;
			
			System.out.println("#"+t+" "+max);
		}
	}
}
