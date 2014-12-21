public class main2 {

	public static void main(String args[]) {		
		int n = 1000;
		System.out.println("f( " + n + " ) = " + f(n));
	}
	
	public static String f(int n)
	{
		int [] ladderTypes = {1, 3, 5};
		String [] f = new String[n + 1];
		f[0] = "1";
		
		for (int totalLen = 1; totalLen <= n; totalLen++) {			
			for (int ladderLen:ladderTypes) {
				if (totalLen >= ladderLen) {
					f[totalLen] = add(f[totalLen], f[totalLen - ladderLen]);
				}
			}
		}
		
		return f[n];
	}
	
	public static String add(String numStr1, String numStr2)
	{		
		if (numStr1 == null) {
			numStr1 = "0";
		}
		
		if (numStr2 == null) {
			numStr1 = "0";
		}
	
		String computeStr = "";
		int strlen1 = numStr1.length(), strlen2 = numStr2.length();
		
		if (strlen1 == strlen2) {
			numStr1 = "0" + numStr1;
			numStr2 = "0" + numStr2;
		}
		else if (strlen1 > strlen2) {			
			numStr1 = "0" + numStr1;
			for (int i = 0; i <= strlen1 - strlen2; i++) {				
				numStr2 = "0" + numStr2;
			}
		}
		else if (strlen1 < strlen2) {			
			numStr2 = "0" + numStr2;
			for (int i = 0; i <= strlen2 - strlen1; i++) {
				numStr1 = "0" + numStr1;
			}
		}		
	
		int lastDigit1, lastDigit2, sum;
		boolean isCarry = false;
		
		for (int i = numStr1.length() - 1; i >= 0; i--) {
			lastDigit1 = Integer.parseInt(String.valueOf(numStr1.charAt(i)));
			lastDigit2 = Integer.parseInt(String.valueOf(numStr2.charAt(i)));
			sum = lastDigit1 + lastDigit2;
			
			if (isCarry) {
				isCarry = false;
				sum += 1;
			}
			
			if (sum >= 10) {
				isCarry = true;
				computeStr = (sum % 10) + computeStr;
			}
			else {
				computeStr = sum + computeStr;
			}
		}
	
		
		if (computeStr.charAt(0) == '0') {
			return computeStr.substring(1);
		}
		else {
			return computeStr;
		}	
	}
}