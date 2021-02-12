package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_0212_D3_1230_¾ÏÈ£¹®3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int N = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			
			for(int i=0;i<N;i++) 
				list.add(sc.nextInt());
			
			int cnt = sc.nextInt();
			
			for(int i=0;i<cnt;i++) {
				char cmd = sc.next().charAt(0);
				
				if(cmd == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=0;j<y;j++) {
						int s = sc.nextInt();
						list.add(x,s);
						x++;
					}
				}
				else if(cmd == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=0;j<y;j++)
						list.remove(x);
				}
				else if(cmd == 'A') {
					int y = sc.nextInt();
					for(int j=0;j<y;j++) {
						int s = sc.nextInt();
						list.add(s);
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
