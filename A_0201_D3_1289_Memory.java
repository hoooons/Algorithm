package Java;

import java.util.Scanner;

public class A_0201_D3_1289_Memory {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
         int T = Integer.parseInt(sc.nextLine());
         for (int i = 1; i <= T; i++) {
         char[] arr = sc.nextLine().toCharArray();
         int count = 0;
         int result = 0;

         for (int j = 0; j < arr.length; j++) {
             if (arr[j]-'0'!=result) {
                 count++;
                 if (result == 0)
                     result = 1;
                 else if (result == 1)
                     result = 0;
             }
         }
         System.out.println("#" + i + " " + count);
		}
	}
}
