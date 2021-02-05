package Java;

import java.util.Scanner;
import java.util.Stack;

public class A_0205_D3_1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int count=0;
			Stack<Integer> st = new Stack<>();
			for(int j=0;j<N;j++) {
				for(int i=0;i<N;i++) {
					if(arr[i][j]==1) {
						st.push(arr[i][j]);
					}
					else if(arr[i][j]==2) {
						if(st.isEmpty()) {
							st.push(arr[i][j]);
						}
						else {
							if(st.peek()==1) {
								count++;
								st.clear();
							}
							else if(st.peek()!=1) {
								st.push(arr[i][j]);
							}
						}
					}
				}
				st.clear();
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
