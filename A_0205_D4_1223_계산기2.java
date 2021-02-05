package Java;

import java.util.Scanner;
import java.util.Stack;

public class A_0205_D4_1223_°è»ê±â2 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			Stack<Character> st = new Stack<>();
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (0 <= str.charAt(i) - '0' && str.charAt(i) - '0' <= 9) {
					sb.append(str.charAt(i));
				} else if (str.charAt(i) == '+') {
					if (!st.isEmpty()) {
						if (st.peek() == '*' || st.peek() == '/') {
							while (!st.isEmpty()) {
								sb.append(st.pop());
							}
						}
						st.push(str.charAt(i));
					} else
						st.push(str.charAt(i));
				} else if (str.charAt(i) == '*') {
					st.push(str.charAt(i));
				}
				if(i==str.length()-1)
					while(!st.isEmpty()) {
						sb.append(st.pop());
					}
			}		
			Stack<Integer> st2 = new Stack<>();
			for(int i=0;i<str.length();i++) {
				if(sb.charAt(i) != '*' && sb.charAt(i) != '+') {
					st2.push(sb.charAt(i)-'0');
				}
				else {
					if(sb.charAt(i) == '*') {
						int x = st2.pop();
						int y = st2.pop();
						st2.push(x*y);
					}
					else {
						int x = st2.pop();
						int y = st2.pop();
						st2.push(x+y);
					}	
				}
			}
			System.out.println("#"+t+" "+st2.pop());
		}

	}
}
