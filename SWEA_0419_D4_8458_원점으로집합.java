package Java;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_0419_D4_8458_원점으로집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int[] len = new int[N];
			for(int i=0;i<N;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				len[i] = Math.abs(x) + Math.abs(y); 
			}
			int cnt = 0;
			for(int i=1;i<N;i++) {
				if(len[0]%2!=len[i]%2) cnt = -1;
			}
			Arrays.sort(len);
			int max = len[N-1];
			while(cnt>=0) {
				if(max == 0) break;
				if(max < 0 && -max % 2 == 0) break;
				cnt++;
				max-=cnt;
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
