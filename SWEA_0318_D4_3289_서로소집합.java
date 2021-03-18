import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_0318_D4_3289_서로소집합 {
	static int N,M;
    static int[] arr;
    static int[] rank;
    static String res;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         int T = Integer.parseInt(br.readLine());
         for(int t=1;t<=T;t++) {
             st = new StringTokenizer(br.readLine());
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
  
             arr = new int[N+1];
             rank = new int[N+1];
             
             make();
             res ="";
             for(int i=0;i<M;i++) {
                 st = new StringTokenizer(br.readLine());
                 int select = Integer.parseInt(st.nextToken());
                 int a = Integer.parseInt(st.nextToken());
                 int b = Integer.parseInt(st.nextToken());
                  
                 if(select==0) 
                	 union(a,b);   // 합집합 연산
                 else          
                	 check(a,b);   // 같은집합인지 확인
             }
             System.out.println("#"+t+" "+ res);
         }
     }
     private static void make() {
         for(int i=1;i<N+1;i++) {
             arr[i]=i;
             rank[i]=1;
         }
     }
     private static int find(int a) {
         if(arr[a]==a) 
        	 return a;
         else {
             return arr[a] = find(arr[a]);
         }
     }
     private static void union(int a, int b) {
         if(rank[find(a)]<rank[find(b)]) {
        	 arr[find(a)] = find(b);
         }
         else {
        	 if(rank[find(a)]==rank[find(b)]) {
        		 arr[find(b)] = find(a);
        		 rank[find(a)]++;
        	 }
         }
     }
     private static void check(int a,int b) {
         if(find(a)==find(b)) {
             res+=1;
         }
         else
             res+=0;
     }
	
}
