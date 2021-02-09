package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_0209_D3_1234_비밀번호 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			List<Integer> list = new ArrayList<>();
			int N = sc.nextInt();
			String s = sc.next();
			for(int i=0;i<N;i++) 
				list.add(s.charAt(i)-'0');
			
			int i=0;
			outer : while(true) {
				for(i=0;i<list.size();i++) {
					if(i+1<list.size() && list.get(i)==list.get(i+1)) {
						list.remove(i);
						list.remove(i);
						break;
					}
					if(i==list.size()-1) break outer;
				}
			}
			System.out.print("#"+t+" ");
			for(i=0;i<list.size();i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}
}
