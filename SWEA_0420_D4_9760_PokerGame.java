package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_0420_D4_9760_PokerGame {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String res = "";
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] card = new char[5];	// 무늬
			int[] num = new int[5];		// 숫자
			for(int i=0;i<5;i++) {		// 입력
				String s = st.nextToken();
				card[i] = s.charAt(0);
				if(s.charAt(1)=='A') {
					num[i] = 1;
				}else if(s.charAt(1)=='T') {
					num[i] = 10;
				}else if(s.charAt(1)=='J') {
					num[i] = 11;
				}else if(s.charAt(1)=='Q') {
					num[i] = 12;
				}else if(s.charAt(1)=='K') {
					num[i] = 13;
				}else {
					num[i] = s.charAt(1)-'0';
				}
			}
			Arrays.sort(card);
			Arrays.sort(num);
			int check = 0;
			// 스티플
			if(check==0) {	
				int tmp = num[0];
				for(int i=1;i<5;i++) {
					if(num[i]!=++tmp) {
						--tmp;
						break;
					}
					if(i==4) {
						char tmp2 = card[0];
						int cnt = 0;
						for(int j=0;j<5;j++) {
							if(tmp2==card[j]) {
								cnt++;
							}
						}
						if(cnt==5) {
							res = "Straight Flush";
							check=1;
						}
					}
				}
				if(tmp==1) {
					tmp = 9;
					for(int i=1;i<5;i++) {
						if(num[i]!=++tmp) {
							break;
						}
						if(i==4) {
							char tmp2 = card[0];
							int cnt = 0;
							for(int j=0;j<5;j++) {
								if(tmp2==card[j]) {
									cnt++;
								}
							}
							if(cnt==5) {
								res = "Straight Flush";
								check=1;
							}
						}
					}
				}
				
			}
			// 포카
			if(check==0) {
				int tmp = num[0], tmp2 = num[1];
				int cnt = 0,cnt2 = 0;
				for(int i=0;i<5;i++) {
					if(tmp==num[i]) {
						cnt++;
					}else if(tmp2==num[i]) {
						cnt2++;
					}
				}
				if(cnt==4 || cnt2==4) {
					res = "Four of a Kind";
					check=1;
				}
			}
			// 풀하우스
			if(check==0) {
				int idx = 0;
				for(int i=0;i<5;i++) {
					int cnt = 0;
					for(int j=i+1;j<5;j++) {
						if(num[i]==num[j])cnt++;
						if(cnt==2) 
							idx = num[i];
					}
					if(cnt==2) {
						int cnt2 = 0;
						for(int a=0;a<5;a++) {
							for(int b=a+1;b<5;b++) {
								if(num[a]!=idx && num[a]==num[b]) cnt2++;
							}
						}
						if(cnt2==1) {
							res = "Full House";
							check = 1;
						}
					}
				}
			}
			// 플러쉬
			if(check==0) {
				char tmp = card[0];
				int cnt = 0;
				for(int i=0;i<5;i++) {
					if(tmp==card[i]) {
						cnt++;
					}
				}
				if(cnt==5) {
					res = "Flush";
					check=1;
				}
			}
			// 스트레이트
			if(check==0) {
				int tmp = num[0];
				for(int i=1;i<5;i++) {
					if(num[i]!=++tmp) {
						--tmp;
						break;
					}
					if(i==4) {
						res = "Straight";
						check = 1;
					}
				}
				if(tmp==1) {
					tmp = 9;
					for(int i=1;i<5;i++) {
						if(num[i]!=++tmp) {
							break;
						}
						if(i==4) {
							res = "Straight";
							check = 1;
						}
					}
				}
			}
			// 삼카
			if(check==0) {
				for(int i=0;i<5;i++) {
					int cnt = 0;
					for(int j=i+1;j<5;j++) {
						if(num[i]==num[j])cnt++;
					}
					if(cnt==2) {
						res = "Three of a kind";
						check = 1;
						break;
					}
				}
			}
			// 투카
			if(check==0) {
				int cnt=0, cnt2=0;
				for(int i=0;i<5;i++) {
					for(int j=i+1;j<5;j++) {
						if(num[i]==num[j] && cnt==0) {
							cnt++;
						}else if(num[i]==num[j] && cnt!=0) {
							cnt2++;
						}
					}
				}
				if(cnt==1 && cnt2==1) {
					res = "Two pair";
					check = 1;
				}
			}
			// 원카
			if(check==0) {
				int cnt = 0;
				for(int i=0;i<5;i++) {
					for(int j=i+1;j<5;j++) {
						if(num[i]==num[j]) {
							cnt++;
						}
					}
				}
				if(cnt==1) {
					res = "One pair";
					check=1;
				}
			}
			// 노카
			if(check==0) res = "High card";
			System.out.println("#"+t+" "+res);
		}
	}
}
