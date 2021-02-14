package Java;

import java.util.Scanner;

public class A_0214_D3_1493_수의새로운연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int tmp1 = 1, tmp2 = 1,tmp3=1;
			int result=1;
			while (true) {
				if (a - tmp1 <= 0)
					break;
				a -= tmp1;
				tmp1 += 1;
			}
			while (true) {
				if (b - tmp2 <= 0)
					break;
				b -= tmp2;
				tmp2 += 1;
			}
			int x1=1,x2=1,y1=tmp1,y2=tmp2,x,y;
			while(true) {
				if(a==1) break;
				a-=1;
				x1++;
				y1--;
			}
			while(true) {
				if(b==1) break;
				b-=1;
				x2++;
				y2--;
			}
			x=x1+x2;
			y=y1+y2;
			while(true) {
				x--;
				y++;
				result++;
				if(x==1)
					break;
			}
			while(true) {
				
				result+=tmp3;
				tmp3+=1;
				
				if(tmp3==y) break;
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
