package arrayReverse;

public class ExponentialSearch {
	
	public static int BinarySearch(int[] arr,int left,int right,int target) {
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(target == arr[mid])return mid;
			else if(arr[mid]<target)left =mid+1;
			else right = mid-1;
		}
		
		return -1;
		
	}
	
	public static int ExponentialSearch(int[] arr , int target) {
		if(target == arr[0])return 0;
		int i =1;
		if(target == arr[i])return i;
		while(i < arr.length-1 && arr[i] <= target ) {
			i = i *2;		
		}
		return BinarySearch(arr,i/2,Math.min(i,arr.length-1 ),target);
		
	
	}
	public static void main(String [] args) {
		int [] arr = {1,3,4,5,6,7,8,9,10,11,12,13,14,15,17,19};
		 int i =ExponentialSearch(arr , 11);
		 System.out.println(i);
		 System.out.println(arr[i]);
		 
				 
	}
}
