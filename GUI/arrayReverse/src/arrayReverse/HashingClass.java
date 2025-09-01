package arrayReverse;

public class HashingClass {

	static int polynomialHash(String s) {
		int p = 31 ,m =1_000_000_009;
		long hash = 0 , power =1;
		for(char c : s.toCharArray()) {
			hash =  (hash + (c='a' +1)* power)%m; 
			power = (power * p )% m;
		}
		return (int) hash;
	}
	static int multiplyHash (String s) {
		int hash = 0;
		int prime =31;
		for(char c : s.toCharArray()) {
			hash = (hash * prime +c) % 100000; 
		}
		return (int)hash;
		
	}
	static int combine(String s) {
		int p = 31 ,m =1_000_000_009 , prime =31;
		long hash = 0 , power =1;
		for(char c : s.toCharArray()) {
			hash =  (hash + (c='a' +1)* power)%m;
			hash = (hash * prime +c) % 100000; 
			power = (power * p )% m;
		}
		return (int) hash;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(polynomialHash("MOHSIN kasjdhakjfhbsdivkbhdsufgausj"));
		System.out.println(polynomialHash("NISHOM"));
		System.out.println(multiplyHash("MOHSIN"));
		System.out.println(multiplyHash("NISHOM"));
		System.out.println(combine("MOHSIN"));
		System.out.println(combine("NISHOM"));
		
	}

}