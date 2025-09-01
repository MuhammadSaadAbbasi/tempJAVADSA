package dsaArray;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {143,67,22,31,110};
		for(int i =0 ; i < arr.length; i++) {
		boolean isSort = false;
		for(int j = 0 ; j < arr.length-1-i; j++)  {
			if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                isSort =true;
			}
		}
		if(!isSort)break;
		}
		for (int a : arr) {
			System.out.println(a);
		}
	}

}
