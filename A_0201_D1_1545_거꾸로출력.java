package Java;

import java.util.Scanner;

public class A_0201_D1_1545_거꾸로출력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=n;i>=0;i--) {
			System.out.print(i);
			if(n==0)
				break;
			System.out.print(" ");
		}
	}
}
