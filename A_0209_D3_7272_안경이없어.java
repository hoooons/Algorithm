package Java;

import java.util.Scanner;

public class A_0209_D3_7272_안경이없어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String s1 = sc.next();
			String s2 = sc.next();
			int[] arr1 = new int[3];
			int[] arr2 = new int[3];
			int res1 = 0, res2 = 0;
			String result = "DIFF";
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == 'B') res1+=37;
				else if (s1.charAt(i) == 'A' || s1.charAt(i) == 'D' || s1.charAt(i) == 'O' || s1.charAt(i) == 'P'
						|| s1.charAt(i) == 'Q' || s1.charAt(i) == 'R')
					res1+=53;
				else 
					res1+=89;
				if (s2.charAt(i) == 'B') res2+=37;
				else if (s2.charAt(i) == 'A' || s2.charAt(i) == 'D' || s2.charAt(i) == 'O' || s2.charAt(i) == 'P'
						|| s2.charAt(i) == 'Q' || s2.charAt(i) == 'R')
					res2+=53;
				else
					res2+=89;
				
				if(res1!=res2) break;
				if(i==s1.length()-1)
					result="SAME";
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
