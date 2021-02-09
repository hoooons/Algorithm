package Java;

import java.util.Scanner;

public class A_0209_D3_1213_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String str = sc.nextLine();
			int count = 0;
			
			for(int i=0;i<str.length();i++) {
				if(s.charAt(0)==str.charAt(i)) {
					for(int j=0;j<s.length();j++) {
						if(i+j>=str.length()) break;
						if(s.charAt(j)!=str.charAt(i+j)) break;
						if(j==s.length()-1) count++;
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
