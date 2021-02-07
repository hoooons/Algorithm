package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_0205_D3_3499_∆€∆Â∆Æº≈«√ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String[] str = new String[N];
			for (int i = 0; i < N; i++) {
				str[i] = sc.next();
			}
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			int size = N / 2;
			for (int i = 0; i < N; i++) {
				if (N % 2 == 1) {
					size = N / 2 + 1;
					if (i < N / 2 + 1)
						q1.offer(str[i]);
					else
						q2.offer(str[i]);
				} else {
					if (i < N / 2)
						q1.offer(str[i]);
					else
						q2.offer(str[i]);
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < size; i++) {
				System.out.print(q1.poll() + " ");
				if (N % 2 == 1 && i == size - 1)
					break;
				System.out.print(q2.poll() + " ");
			}
			System.out.println();
		}
	}
}
