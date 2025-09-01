package dsaArray;

public class selectionSort {
 
	static int[] sort(int [] arr) {
		for(int i = 0 ; i <arr.length-1 ; i++) {
			int min = i;
			//not last eleemrnt bcz all will be already sorted
			for(int j = i+1 ; j < arr.length ; j++) {
				if(arr[i]>arr[j]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min]=temp;
			
		}
		
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {143,87,23,31,110};
		int[] arr1 = sort(arr);
		for (int a : arr1) {
			System.out.println(a);
		}
	}
}
