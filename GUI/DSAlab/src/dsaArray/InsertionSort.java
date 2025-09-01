package dsaArray;
class Object{
	int model ;
	String name, company;
	Object(int m , String n, String c){
		model =m;
		name = n;
		company = c;
	}
	
}
public class InsertionSort {
	static int[] sort(int[] arr) {
		for(int i =1 ; i < arr.length; i++) {
			int j = i-1;
			int key = arr[i];
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		return arr;
	}
	static Object[] sort(Object[] arr) {
		
		for(int i =1 ; i < arr.length; i++) {
			int j = i-1;
			Object key = arr[i];
			while(j>=0 && arr[j].name.compareTo(key.name)>0) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
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
		Object []car =  new Object[5];
		car[0] =  new Object(2000, "Alto","Suzuki");
		car[1] =  new Object(2000, "Ferrari","Ferrari");
		car[2] =  new Object(2000, "Mercedes","Mercedes");
		car[3] =  new Object(2000, "Lamborghini","Lamborghini");
		car[4]=  new Object(2000, "BMW","BMW");
		
		Object[] sort = sort(car);
		for (Object a : sort) {
			System.out.println(a.name);
		}
		
		
	}
//lexicographical with alphabeticak irrder
}
