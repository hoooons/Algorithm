package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_0208_D3_1228_¾ÏÈ£¹®1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int N = sc.nextInt();
			
			List<Integer> list = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				list.add(sc.nextInt());
			}
			
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				char a = sc.next().charAt(0);
				if(a=='I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=0;j<y;j++) {
						int num = sc.nextInt();
						list.add(x, num);
						x++;						//»ðÀÔÈÄ ´ÙÀ½Ä­¿¡ »ðÀÔ
					}
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<10;i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}
