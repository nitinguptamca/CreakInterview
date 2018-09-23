package Question1_3;

import CareerCupLibrary.*;

public class Question {
	
	public void removeDuplicates(String str)  {
		boolean[] char_set=new boolean[256];
		char[] charArr=str.toCharArray();
		int tail=1;
		int len = charArr.length;
		
		for (int i = 2; i < len; ++i) {
			for(int j=0 ;j<i;j++) {
				if(charArr[i]==charArr[j]) {
					
				}else {
					
				}
			}
		}
		
		
		
	}

	public static void removeDuplicates(char[] str) {
		if (str == null) {
			return;
		}
		int len = str.length;
		if (len < 2) {
			return;
		}
		int tail = 1;
		
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j)
				if (str[i] == str[j]) {
					break;
				}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	} 
	
	public static void removeDuplicatesEff(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;

		boolean[] hit = new boolean[256];
		
		hit[str[0]] = true;

		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
	
	
	public static void removeDuplicatesEff1(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;

		boolean[] hit = new boolean[256];
		
		int tail = 0;
		for (int i = 0; i < len; ++i) {
			char dsd=str[i];
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
	
	public static void removeDuplicatechar(String str) {
		boolean[] boolArr=new boolean[256];
		char[] charArr=str.toCharArray();
		char[] tmpArr=new char[charArr.length];
		int tail=1;
		for(int i=0 ;i<charArr.length;i++) {
			int val=str.charAt(i);
			if(boolArr[val]) {
				
			}else {
				boolArr[val]=true;
				tmpArr[tail]=charArr[i];
				tail++;
			}
		}
		
		System.out.println(tmpArr.toString());
	}
	
	
	
	public static void main(String[] args) {
		String s = "helloiloveyoufsgsgweerwrwersdfsdf";
		removeDuplicatechar(s);
		char[] arr = s.toCharArray();
		/*removeDuplicatesEff(arr);
		System.out.println(AssortedMethods.charArrayToString(arr));
		*/
		removeDuplicatesEff1(arr);
		System.out.println(AssortedMethods.charArrayToString(arr));
		
	}

}
