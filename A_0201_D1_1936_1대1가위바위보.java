package Java;

import java.util.Scanner;

public class A_0201_D1_1936_1대1가위바위보 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a==1) {
			if(b==2)
				System.out.println('B');
			if(b==3)
				System.out.println('A');
		}
		if(a==2) {
			if(b==3)
				System.out.println('B');
			if(b==1)
				System.out.println('A');
		}
		if(a==3) {
			if(b==1)
				System.out.println('B');
			if(b==2)
				System.out.println('A');
		}
	}
}
