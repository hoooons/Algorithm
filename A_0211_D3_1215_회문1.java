package Java;

import java.util.Scanner;

public class A_0211_D3_1215_È¸¹®1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(sc.next());
			char[][] arr = new char[8][8];
			for(int i=0;i<8;i++) {
				String s = sc.next();
				for(int j=0;j<8;j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int count = 0;
			
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					if(j+N>8) break;
					for(int k=0;k<N/2;k++) {			
						if(arr[i][j+k]!=arr[i][j+N-1-k])
							break;
						
						if(k==N/2-1)
							count++;
					}
				}
			}
			for(int j=0;j<8;j++) {
				for(int i=0;i<8;i++) {
					if(i+N>8) break;
					for(int k=0;k<N/2;k++) {			
						if(arr[i+k][j]!=arr[i+N-1-k][j])
							break;
						
						if(k==N/2-1)
							count++;
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
