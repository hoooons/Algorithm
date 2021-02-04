package Java;

import java.util.Scanner;
import java.util.Stack;

public class A_0204_D4_1218_°ýÈ£Â¦Áþ±â {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] open = {'(','{','[','<'};
		char[] close = {')','}',']','>'};
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(sc.next());
			String s = sc.next();
			Stack<Character> st = new Stack<>();
			int result = 1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<4;j++) {
					if(s.charAt(i)==open[j]) {
						st.push(open[j]);
						break;
					}
					else if(s.charAt(i)==close[j]) {
						if(open[j]==st.peek()) {
							st.pop();
							break;
						}
						else {
							result = 0;
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
