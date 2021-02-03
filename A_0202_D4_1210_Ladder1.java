package Java;

import java.util.Scanner;

public class A_0202_D4_1210_Ladder1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n=sc.nextInt();
			int r = 0,c=0;
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					if(i==99 && arr[i][j] == 2) {
						r=i; c=j;
					}
				}
			}
			while (r > 0) { 
				if (c != 0 && arr[r][c - 1] == 1) {	
					while (true) {
						c--;
						if (c == 0 || arr[r][c - 1] == 0) {
							r--; break;
						}
					}
				} else if (c != 99 && arr[r][c + 1] == 1) {	
					while (true) {
						c++;
						if (c == 99 || arr[r][c + 1] == 0) {
							r--; break;
						}
					}
				} else if (arr[r - 1][c] == 1)	
					r--;	
			}
			System.out.println("#"+n+" "+c);
		}
	}
}
