package arrayReverse;

public class binarySearchcopy {

//	public binarySearchcopy() {
//		// TODO Auto-generated constructor stub
//	}
	public static int binarySearch(int [] arr , int target) {
	
	int p = 0;
	int q = arr.length-1;
	
	
	while(p<=q) {
		int mid = (p+q)/2;
		if(target == arr[mid])return mid;
		else if(arr[mid]<target)p =mid+1;
		else q = mid-1;
	}
	
	return -1;
	}
	
	public static int findOthers(int [] arr , int target) {
	}	
	
	public static void main(String [] args) {
		int [] arr = {1,2,3,4,5,5,5,8,9,10};
		int x = binarySearch(arr,5);
		int target =5;
		System.out.println(x);
//		System.out.println(arr[x]);
//		if (arr[x-1] == target) {
//			System.out.println(x-1);	
//		}
//		if (arr[x+1] == target) {
//			System.out.println(x+1);	
//		}
	}
}
