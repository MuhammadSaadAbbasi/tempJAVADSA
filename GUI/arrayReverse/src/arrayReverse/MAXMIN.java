package arrayReverse;

public class MAXMIN {
	public static void arrPrint(int [] arr) {
		for(int i = 0 ; i < 50 ;i++) {
		System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[50];
		
        

		for(int i = 0 ; i < 50 ;i++) {
			arr[i]=(int)(Math.random()*50)+1;
		}
		int max = arr[0];
        int min = arr[0];
		
		for(int i = 0 ; i < 50 ;i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		for(int i = 0 ; i < 50 ;i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
	}
		arrPrint(arr);
		System.out.println("Max : " + max);
		
		System.out.println("Min : " + min);
	
}
}