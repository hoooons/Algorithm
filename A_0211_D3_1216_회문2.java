package Java;

import java.util.Scanner;

//100부터 비교하면 더 좋을거같음.
//틀렸던점 18에서 19없이 20으로넘어감
public class A_0211_D3_1216_회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int n = Integer.parseInt(sc.next());
			char[][] arr = new char[100][100];
			for(int i=0;i<100;i++) {
				String s = sc.next();
				for(int j=0;j<100;j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int result = 0;
			int N=3;
			outer : while(N<100) {
				for(int i=0;i<100;i++) {
					for(int j=0;j<100;j++) {
						if(j+N>100) break;
						for(int k=0;k<N/2;k++) {			
							if(arr[i][j+k]!=arr[i][j+N-1-k])
								break;
							
							if(k==N/2-1) {
								result = N;
								N++;
								continue outer;
							}
						}
					}
				}
				for(int j=0;j<100;j++) {
					for(int i=0;i<100;i++) {
						if(i+N>100) break;
						for(int k=0;k<N/2;k++) {			
							if(arr[i+k][j]!=arr[i+N-1-k][j])
								break;
							
							if(k==N/2-1) {
								result=N;
								N++;
								continue outer;
							}
						}
					}
				}
				N++;
			}
			System.out.println("#"+t+" "+result);
		}
	}
}