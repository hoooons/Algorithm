package Java;

import java.util.Scanner;

public class A_0205_D3_1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			int dif1 = 0, dif2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						dif1 = 0;
						dif2 = 0;
						for (int r = i + 1; i < N; r++) {
							if (r == N)
								break;
							if (arr[r][j] == 1)
								break;
							else if (arr[r][j] == 2) {
								if ((r - i) % 2 == 0) {
									dif1 = (r - i) / 2 - 1;
									dif2 = (r - i) / 2;
								} else if ((r - i) % 2 == 1) {
									dif1 = (r - i) / 2;
									dif2 = (r - i) / 2;
								}
								arr[i][j] = 0;
								arr[i + dif1][j] = 1;
								arr[r][j] = 0;
								arr[r - dif2][j] = 2;
								break;
							}
						}
					} else if (arr[i][j] == 2) {
						dif1 = 0;
						dif2 = 0;
						for (int r = i - 1; r >= 0; r--) {
							if (r == -1)
								break;
							if (arr[r][j] == 2)
								break;
							else if (arr[r][j] == 1) {
								if ((i - r) % 2 == 0) { // Â¦¼ö
									dif1 = (i - r) / 2 - 1;
									dif2 = (i - r) / 2;
								} else if ((i - r) % 2 == 1) {
									dif1 = (i - r) / 2;
									dif2 = (i - r) / 2;
								}
								arr[i][j] = 0;
								arr[i - dif2][j] = 2;
								arr[r][j] = 0;
								arr[r + dif1][j] = 1;
								break;
							}
						}
					}
				}
			}
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (i + 1 < N && arr[i][j] == 1 && arr[i + 1][j] == 2) {
						count++;
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
