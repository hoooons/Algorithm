package Java;

import java.util.Scanner;

public class A_0209_D2_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int tc = sc.nextInt();
			int[] arr = new int[101];
			int max = 0,result=0;
			for(int i=0;i<1000;i++) {
				int n = sc.nextInt();
				arr[n]++;
			}
			for(int i=0;i<101;i++) {
				if(max<=arr[i]) {
					if(max==arr[i]) result = i;
					max=arr[i];
					result=i;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
