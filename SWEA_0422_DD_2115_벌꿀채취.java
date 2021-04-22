package Java;

import java.util.Scanner;

public class SWEA_0422_DD_2115_벌꿀채취 {
	
	// new idea => 일꾼하나를 먼저 탐색후 값을 0으로 바꾼뒤 차선의 이익을 찾는다.
	static int N,M,C,res1,res2;
	static int x1,y1,x2,y2;
	static int[][] arr;
	static int[] tmp;
	static boolean[] ans;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int t=1;t<=T;t++) {
	            N = sc.nextInt();   // 배열크기
	            M = sc.nextInt();   // 꿀통 수
	            C = sc.nextInt();   // 최대용량
	            arr = new int[N][N];
	             
	            tmp = new int[M];
	            res1=0; res2=0;
	            x1=-100;y1=-100;x2=-100;y2=-100;
	             
	            for(int i=0;i<N;i++)
	                for(int j=0;j<N;j++)
	                    arr[i][j] = sc.nextInt();
	             
	            for(int i=0;i<N;i++) {
	                for(int j=0;j<=N-M;j++) {
	                    int idx = 0;
	                    int temp = 0;
	                     
	                    for(int k=j;k<j+M;k++) {
	                        tmp[idx++] = arr[i][k];
	                        temp+=arr[i][k];
	                    }
	                    if(temp<=C) {
	                        int bee = 0;
	                        for(int k=0;k<M;k++) {
	                            bee += tmp[k] * tmp[k];
	                        }
	                        if(Math.min(res1, res2)<bee) {
	                            if(res1==res2) {
	                                if(i==x2 && Math.abs(j-y2)<M) {
	                                    if(res2<bee) res2 = bee;
	                                }
	                                else {
	                                    x1 = i;
	                                    y1 = j;
	                                    res1 = bee;
	                                }
	                            }
	                            else if(res1<res2) {
	                                if(i==x2 && Math.abs(j-y2)<M) {
	                                    if(res2<bee) res2 = bee;
	                                }
	                                else {
	                                    x1 = i;
	                                    y1 = j;
	                                    res1 = bee;
	                                }
	                            }
	                            else if(res1>res2) {
	                                if(i==x1 && Math.abs(j-y1)<M) {
	                                    if(res1<bee) res1 = bee;
	                                }
	                                else {
	                                    x2 = i;
	                                    y2 = j;
	                                    res2 = bee;
	                                }
	                            }
	                        }
	                    }
	                    else if(temp>C) {
	                        ans = new boolean[M];
	                        sub(0,i,j);
	                    }
	                }
	            }
	            System.out.println("#"+t+" "+(res1+res2));
	        }
	    }
	    private static void sub(int cnt,int i,int j) {
	        if(cnt==M) {
	            int count = 0,sum = 0; 
	            for(int k=0;k<M;k++) {
	                if(ans[k]==true) {
	                    count+=tmp[k];
	                    sum+=tmp[k]*tmp[k];
	                }
	            }
	            if(count<=C && Math.min(res1, res2)<sum) {
	                if(res1==res2) {
	                    if(i==x2 && Math.abs(j-y2)<M) {
	                        if(res2<sum) res2 = sum;
	                    }
	                    else {
	                        x1 = i;
	                        y1 = j;
	                        res1 = sum;
	                    }
	                }
	                else if(res1<res2) {
	                    if(i==x2 && Math.abs(j-y2)<M) {
	                        if(res2<sum) res2 = sum; 
	                    }
	                    else {
	                        x1 = i;
	                        y1 = j;
	                        res1 = sum;
	                    }
	                }
	                else if(res1>res2) {
	                    if(i==x1 && Math.abs(j-y1)<M) {
	                        if(res1<sum) res1 = sum; 
	                    }
	                    else {
	                        x2 = i;
	                        y2 = j;
	                        res2 = sum;
	                    }
	                }
	            }
	            return;
	        }
	        ans[cnt] = true;
	        sub(cnt+1,i,j);
	        ans[cnt] = false;
	        sub(cnt+1,i,j);
	    }
	}
