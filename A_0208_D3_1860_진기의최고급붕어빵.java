package Java;

import java.util.Scanner;

public class A_0208_D3_1860_Áø±âÀÇÃÖ°í±ŞºØ¾î»§ {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int count = 0;

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) 
				arr[i] = sc.nextInt();

			int i = 0;
			outer: while (true) {
				i++;
				if (i % M == 0) count += K;
				for (int j = 0; j < N; j++) {
					if(arr[j]==0 && i==1) {
						System.out.println("#" + t + " " + "Impossible");
						break outer;
					}
					if (i == arr[j]) {
						if (count == 0) {
							System.out.println("#" + t + " " + "Impossible");
							break outer;
						} else {
							count--;
							arr[j] = 0;
						}
					}
				}
				for (int j = 0; j < N; j++) {
					if (arr[j] != 0) break;
					if (j == N - 1) {
						System.out.println("#" + t + " " + "Possible");
						break outer;
					}
				}
			}
		}
	}
}
