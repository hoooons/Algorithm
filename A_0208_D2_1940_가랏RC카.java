package Java;

import java.util.Scanner;

public class A_0208_D2_1940_°¡¶ùRCÄ« {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int sp = 0, sum = 0, y = 0;
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				if (x != 0) y = sc.nextInt();
				if (x == 0) sum += sp;
				else if (x == 1) {
					sp += y;
					sum += sp;
				} else if (x == 2) {
					if (sp - y < 0) {
						sp = 0;
						continue;
					}
					sp -= y;
					sum += sp;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
