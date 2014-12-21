public class main {

	public static void main(String args[]){
		int n = 50;
		System.out.println("f( " + n + " ) = " + f(n));
	}
		
	public static long f(int n)
	{
		int [] ladderTypes = {1, 3, 5};
		long [] f = new long[n + 1];
		f[0] = 1;
		
		for (int totalLen = 1; totalLen <= n; totalLen++) {			
			for (int ladderLen:ladderTypes) {
				if (totalLen >= ladderLen) {
					f[totalLen] += f[totalLen - ladderLen];
				}
			}
		}
		
		return f[n];
	}
}
