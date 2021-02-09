package Java;

import java.util.Scanner;

public class A_0209_D2_1974_스도쿠검증 {
	
	static int res;
	static int[][] arr;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			arr = new int[9][9];
			num = new int[10];
			res = 1;
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					arr[i][j] = sc.nextInt();

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					num[arr[i][j]]++;
					if(num[arr[i][j]]==2) res=0;
				}
				num = new int[10];
			}
			for (int j = 0; j < 9; j++) {
				for (int i = 0; i < 9; i++) {
					num[arr[i][j]]++;
					if(num[arr[i][j]]==2) res=0;
				}
				num = new int[10];
			}
			int a = 0, b = 0;
			for (int i = a; i < 7; i += 3) {
				for (int j = b; j < 7; j += 3) {
					sudo(a, b);
				}
			}

			System.out.println("#" + t + " " + res);
		}
	}
	
	static void sudo(int a, int b) {
		for (int i = a; i < a + 3; i++) {
			for (int j = b; j < b + 3; j++) {
				num[arr[i][j]]++;
				if(num[arr[i][j]]==2)
					res=0;
			}
		}
		num = new int[10];
	}
}
