package Java;

import java.util.Scanner;

public class A_0205_D3_3499_∆€∆Â∆Æº≈«√ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String[] arr = new String[N];
			int size = N / 2;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();
			}
			if (N % 2 == 1) {
				size = N / 2 + 1;
			}
			String[] r = new String[size];
			String[] c = new String[N / 2];
			int j = 0;
			for (int i = 0; i < N; i++) {
				if (i < size) {
					r[i] = arr[i];
				} else if (i >= size) {
					c[j] = arr[i];
					j++;
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < size; i++) {
				System.out.print(r[i] + " ");
				if (N % 2 == 1 && i == size - 1)
					break;
				System.out.print(c[i] + " ");
			}
			System.out.println();
		}
	}
}
